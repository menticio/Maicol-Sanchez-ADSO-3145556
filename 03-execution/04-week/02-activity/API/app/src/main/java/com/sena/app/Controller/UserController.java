package com.sena.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.app.Entity.User;
import com.sena.app.Service.UserService;



@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User savedUser=service.save(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<User>> getAll(){
        List<User> users= service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    } 

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam(required= false) String name){
       

        if(name != null){
            return service.getUserByName(name);
        }
        return service.getAllUsers();
    }

    @GetMapping("/searchId")
    public Optional<User> getById(@RequestParam Long id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        service.delete(id);
        return "Usuario eliminado correctamente";
    }
}
