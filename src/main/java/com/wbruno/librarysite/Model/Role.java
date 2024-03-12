package com.wbruno.librarysite.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    /*@ManyToMany(mappedBy = "role")
    private List<User> users;*/

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }
}
