package io.data.ltbook.repo;
import io.data.ltbook.domain.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepo extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByCodeCart(String codeCart);
}
