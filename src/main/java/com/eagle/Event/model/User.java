package com.eagle.Event.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String lastName;
    private Date birthday;
    private String email;
    private String phone;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable=false)
    private Role role;

    public User(String username, String lastName, String email, String encode) {
        this.username = username;
        this.email = email;
        this.lastName= lastName;
        this.password = encode;
    }
}
