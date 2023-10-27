package com.Mongo.EjemploMongo.service.user;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(UserDto userDto) {
        return userRepository.create(userDto);
    }

    @Override
    public User update(String id, UserDto userDto) {
        return userRepository.update(id, userDto);
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
