package com.wbruno.librarysite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbruno.librarysite.Model.ERole;
import com.wbruno.librarysite.Model.Role;

@Repository
public interface RoleRepository {
    Optional<Role> findByName(ERole name);
}
