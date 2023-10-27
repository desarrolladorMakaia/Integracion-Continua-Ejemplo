package com.Mongo.EjemploMongo.security;

import com.Mongo.EjemploMongo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class OperationJwtImpl implements OperationJwt {

        private final String KeySecret = "Sebas_123";

        @Override
        public String generateJwt(User user, Calendar expirationDate) {

            return Jwts.builder()
                    .setSubject(user.getId())
                    .claim("name", user.getName())
                    .setIssuedAt(new Date())
                    .setExpiration(expirationDate.getTime())
                    .signWith(SignatureAlgorithm.HS256, KeySecret)
                    .compact();
        }

        @Override
        public Boolean validateJwt(String jwt, User user) {
            Boolean isJwtExpired = returnClaims(jwt).getExpiration().before(new Date());
            Boolean isValidJwt = user.getId().equals(extractSubject(jwt))&& !isJwtExpired;
            return isValidJwt;

        }

        @Override
        public Claims returnClaims(String jwt) {
            return Jwts.parser().setSigningKey(KeySecret).parseClaimsJws(jwt).getBody();
        }

        @Override
        public String extractSubject(String jwt) {
            return returnClaims(jwt).getSubject();
        }
}

