package io.data.ltbook.repo;


import io.data.ltbook.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepo extends JpaRepository<Bill,Long> {
    List<Bill> findByIdUser(Long idUser);
//    List<Bill> findCodeCart(String codeCart);
}
