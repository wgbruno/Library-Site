package com.wbruno.librarysite.Services;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbruno.librarysite.Model.User;
import com.wbruno.librarysite.Repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User insert(User userVO) {
        return this.userRepository.save(userVO);
    }

    @Override
    public List<User> findAll() {

        return this.userRepository.findAll();
    }

    @Override
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public User updateUser(long id, User userVO) {
        userVO.setId(id);
        return this.userRepository.save(userVO);
    }
}
