package com.library.librarysite.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    User deleteUserById(Long id);

    Boolean existsByEmail(String email);
}
