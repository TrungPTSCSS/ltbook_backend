package io.data.ltbook.api;


import io.data.ltbook.domain.Bill;
import io.data.ltbook.domain.ProductCart;
import io.data.ltbook.domain.ResponseObject;
import io.data.ltbook.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
@Slf4j
public class BillResource {
    private final DatabaseService databaseService;

    @GetMapping("/GetByQuery")
    public List<Bill> getAllProductCart(){
        return databaseService.getAllBill();
    }


    @GetMapping("/GetByIdUser")
    @ResponseBody
    ResponseEntity<ResponseObject> findByIdUser(@RequestParam Long idUser){
        List<Bill> foundBill = databaseService.findByIdUser(idUser);
        if(foundBill.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail", "can't find productCart", "")
            );
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "query book successfully", foundBill)
            );
        }
    }

    @PostMapping("/Create")
    ResponseEntity<ResponseObject> insertCart(@RequestBody Bill newBill){

//        List<Bill> foundCart = databaseService.findCodeCartInBill(newBill.getCode().trim());
//        if(foundCart.size() > 0){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("fail", "Cart name already exist", "")
//            );
//        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new cart successfully", databaseService.initBill(newBill))
        );
    }

    @PutMapping("/Update")
    @ResponseBody
    ResponseEntity<ResponseObject> updateProductCart(@RequestBody Bill newBill, @PathVariable Long id){
        Bill updatedBill = databaseService.getBillById(id).map(bill -> {
            bill.setIdUser(newBill.getIdUser());
            bill.setCode(newBill.getCode());
            bill.setTotal(newBill.getTotal());
            bill.setStatus(newBill.getStatus());
            bill.setNameCustomer(newBill.getNameCustomer());
            bill.setPhoneCustomer(newBill.getPhoneCustomer());
            bill.setAddressCustomer(newBill.getAddressCustomer());
            return databaseService.initBill(bill);
        }).orElseGet(() -> {
            newBill.setId(id);
            return databaseService.initBill(newBill);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update cart successfully", updatedBill)
        );
    }
}
