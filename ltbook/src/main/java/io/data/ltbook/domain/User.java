package io.data.ltbook.domain;

import antlr.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
//    private String phone;
//    private String email;
//    private List<Token> tokens;
    @ManyToMany(fetch = EAGER)
    private final Collection<Role> roles = new ArrayList<>();

}
