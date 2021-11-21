package io.data.ltbook.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Double price;
    private Integer rating;
    private Integer sold;
    private String description;
    private String artistAvatar;
    private String artistName;
    private String artistBornDay;
    private String type;
    private String status;
    private String createBy;
    private String createAt;
    private String updateBy;
    private String updateAt;
}
