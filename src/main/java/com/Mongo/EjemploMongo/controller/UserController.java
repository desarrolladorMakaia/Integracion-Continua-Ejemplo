package com.Mongo.EjemploMongo.controller;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();
        if (users.size() == 0) {
            return new ResponseEntity("NO HAY USUARIOS", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

    }



    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = userService.findById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity("the id" + id + "is not found", HttpStatus.NOT_FOUND);
        }

    }
     @PostMapping
       public ResponseEntity<User> create(@RequestBody UserDto userDto){
            User user = userService.create(userDto);
            if(user!=null){
            return new ResponseEntity<>(user ,HttpStatus.CREATED);
            }else{
            return new ResponseEntity("Error creating user",HttpStatus.CONFLICT);
           }
    }

     @PutMapping("/{id}")
       public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDto userDto){
            User user = userService.update(id, userDto);
            if(user!=null){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }else{
                return new ResponseEntity("Error updating user", HttpStatus.NOT_FOUND);
            }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
        Boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return new ResponseEntity<>(isDeleted ,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
        }

    }







}
















