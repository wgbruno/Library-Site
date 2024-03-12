package com.wbruno.librarysite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wbruno.librarysite.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
