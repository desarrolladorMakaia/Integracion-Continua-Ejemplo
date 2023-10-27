package com.Mongo.EjemploMongo.service.user;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(String id);
    User create(UserDto userDto);
    User update(String id,UserDto userDto);
    Boolean deleteUser(String id);

    User findByEmail(String email);
}
