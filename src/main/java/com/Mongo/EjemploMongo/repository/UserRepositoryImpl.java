package com.Mongo.EjemploMongo.repository;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.repository.MongoRepositoryU.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


    @Repository
    public class UserRepositoryImpl implements UserRepository{

        private final UserMongoRepository userMongoRepository;

        @Autowired
        public UserRepositoryImpl(UserMongoRepository userMongoRepository) {
            this.userMongoRepository = userMongoRepository;
        }

        @Override
        public List<User> findAll() {
            return userMongoRepository.findAll().size()>0 ? userMongoRepository.findAll() :null;

        }

        @Override
        public User findById(String id) {
            return userMongoRepository.findById(id).isPresent() ?userMongoRepository.findById(id).get():null;
        }

        @Override
        public User create(UserDto userDto) {
            User user =new User(userDto);
            return userMongoRepository.save(user);
        }

        @Override
        public User update(String id, UserDto userDto) {
            User userFound = findById(id);
            if(userFound!= null){
                userFound.setName(userDto.getName());
                userFound.setEmail(userDto.getEmail());
                return userMongoRepository.save(userFound);
            }else {
                return null;
            }
        }


        @Override
        public Boolean deleteUser(String id) {
            User userFound = findById(id);
            if(userFound !=null){
                userMongoRepository.delete(userFound);
                return true;
            }else{
            return false;
            }
        }

        @Override
        public User findByEmail(String email) {
            Optional<User> userFound = userMongoRepository.findByEmail(email);//guardo user en optional uso query mongo creado
            if(userFound.isPresent()){
                return userFound.get();
            }else{
                return null;
            }

        }
    }


