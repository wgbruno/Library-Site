package com.library.librarysite.Controllers;

import com.library.librarysite.Data.User;
import com.library.librarysite.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    void addUser(@RequestBody User user){
        /*User user = new User();
        user.setFirstName(first);
        user.setEmail(email);*/
        userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable Integer id){
        return userRepository.findUserById(id);
    }
}
