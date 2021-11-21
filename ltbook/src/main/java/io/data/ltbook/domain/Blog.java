package io.data.ltbook.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String title;
    private String content;
    private String tags;
    private String status;
    private String createBy;
    private String createAt;
    private String updateBy;
    private String updateAt;
}
