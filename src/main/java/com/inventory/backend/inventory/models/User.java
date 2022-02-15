package com.inventory.backend.inventory.models;

import ch.qos.logback.classic.db.names.ColumnName;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=20)
    private String username;

    @NotBlank
    @Size(max=50)
    private String email;

    @NotBlank
    @Size(max=120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id"))
    private Set<Role> roles = new HashSet<>();

}
