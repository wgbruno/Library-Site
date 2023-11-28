package com.library.librarysite.Data;

import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Integer id);
}
