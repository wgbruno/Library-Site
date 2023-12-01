package com.library.librarysite.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Integer id);

    User deleteUserById(Integer id);
}
