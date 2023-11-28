package com.library.librarysite.Data;

import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserById(Integer id);
}
