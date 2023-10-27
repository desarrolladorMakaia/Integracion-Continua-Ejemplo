package com.Mongo.EjemploMongo.repository.booking;

import com.Mongo.EjemploMongo.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingMongoRepository extends MongoRepository<Booking,String> {
}
