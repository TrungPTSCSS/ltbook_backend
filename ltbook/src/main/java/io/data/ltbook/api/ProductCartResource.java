package io.data.ltbook.api;

import io.data.ltbook.domain.Book;
import io.data.ltbook.domain.ProductCart;
import io.data.ltbook.domain.ResponseObject;
import io.data.ltbook.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productCart")
@RequiredArgsConstructor
@Slf4j
public class ProductCartResource {
    private final DatabaseService databaseService;

    @GetMapping("/GetByQuery")
    public List<ProductCart> getAllProductCart(){
        return databaseService.getAllProductCart();
    }


    @GetMapping("/GetByCodeCart")
    @ResponseBody
    ResponseEntity<ResponseObject> findByCodeCart(@RequestParam String codeCart){
        List<ProductCart> foundProductIncart = databaseService.findByCartCode(codeCart);
        if(foundProductIncart.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail", "can't find productCart", "")
            );
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "query book successfully", foundProductIncart)
            );
        }
    }
    @PostMapping("/Create")
    ResponseEntity<ResponseObject> insertProductCart(@RequestBody ProductCart newProductCart){

        List<ProductCart> foundProductCard = databaseService.findByCartCode(newProductCart.getCodeCart().trim());
        if(foundProductCard.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Product Cart name already exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new product cart successfully", databaseService.initProductCart(newProductCart))
        );
    }
    @PutMapping("/Update")
    @ResponseBody
    ResponseEntity<ResponseObject> updateProductCart(@RequestBody ProductCart productCart, @PathVariable Long id){
        ProductCart updatedProductCart = databaseService.getProductCart(id).map(product -> {
            productCart.setCodeCart(productCart.getCodeCart());
            productCart.setAmount(productCart.getAmount());
            productCart.setIdBook(productCart.getIdBook());
            productCart.setPrice(productCart.getPrice());
            productCart.setTotal(productCart.getTotal());
            productCart.setName(productCart.getName());
            productCart.setRating(productCart.getRating());
            productCart.setImgUrl(productCart.getImgUrl());
            return databaseService.initProductCart(productCart);
        }).orElseGet(() -> {
            productCart.setId(id);
            return databaseService.initProductCart(productCart);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update product cart successfully", updatedProductCart)
        );
    }
}
