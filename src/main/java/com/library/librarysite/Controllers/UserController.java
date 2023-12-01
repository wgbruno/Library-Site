package com.library.librarysite.Controllers;

import com.library.librarysite.Data.User;
import com.library.librarysite.Data.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    //@Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        /*User user = new User();
        user.setFirstName(first);
        user.setEmail(email);*/
        return this.userRepository.save(user);
        //return this.userRepository.insert(user);
    }

    @GetMapping("/showall")
    public /*Iterable<User>*/ ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public /*User*/ ResponseEntity<User> getUser (@PathVariable("id") int id){
        return ResponseEntity.ok(userRepository.findUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") int id){
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
        /*userRepository.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        if(user==null)
            runtime exception
            throw new UserNotFoundException("id: "+ id);*/
    }
}
