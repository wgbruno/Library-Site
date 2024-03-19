package com.wbruno.librarysite.Services;

import java.util.List;

import com.wbruno.librarysite.Model.User;

public interface UserServices {
    public User insert(User userVO);

    public List<User> findAll();

    public void delete(long id);

    public User findById(long id);

    public User updateUser(long id, User userVO);
}
