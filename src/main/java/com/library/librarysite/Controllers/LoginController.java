package com.library.librarysite.Controllers;

import com.library.librarysite.Data.User;
import com.library.librarysite.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last){
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        userRepository.save(user);
        return "Added new user!";
    }

    @GetMapping("/list")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable Integer id){
        return userRepository.findUserById(id);
    }
}
