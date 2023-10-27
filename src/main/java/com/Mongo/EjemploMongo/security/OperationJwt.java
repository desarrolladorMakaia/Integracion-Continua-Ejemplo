package com.Mongo.EjemploMongo.security;

import com.Mongo.EjemploMongo.model.User;
import io.jsonwebtoken.Claims;

import java.util.Calendar;

public interface OperationJwt {
    String generateJwt(User user, Calendar expirationDate);
    Boolean validateJwt(String jwt, User user);
    Claims returnClaims(String jwt);
    String extractSubject(String jwt);

}
