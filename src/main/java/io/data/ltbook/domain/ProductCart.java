package io.data.ltbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeCart;
    private Long idBook;
    private String name;
    private String imgUrl;
    private Integer amount;
    private Integer rating;
    private Double price;
    private Double total;
}
