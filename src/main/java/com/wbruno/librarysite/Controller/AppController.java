package com.wbruno.librarysite.Controller;

import com.wbruno.librarysite.Model.User;

import com.wbruno.librarysite.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;

@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppController {
    @Autowired
    private UserServices userService;

    public Principal user(Principal user) {
        return user;
    }

    @GetMapping
    public List<User> findAllUser() {
        return this.userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable int id) {
        return this.userService.findById(id);
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return this.userService.insert(user);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.delete(id);
    }
}
