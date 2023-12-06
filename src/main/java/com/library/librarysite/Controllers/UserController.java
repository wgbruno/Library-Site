package com.library.librarysite.Controllers;

import com.library.librarysite.Data.User;
import com.library.librarysite.Data.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        return this.userRepository.save(user);
    }

    @GetMapping("/showall")
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public /*User*/ ResponseEntity<User> getUser (@PathVariable("id") long id){
        return ResponseEntity.ok(userRepository.findUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") long id){
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
