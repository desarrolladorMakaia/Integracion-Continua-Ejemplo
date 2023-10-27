package com.Mongo.EjemploMongo.repository.booking;

import com.Mongo.EjemploMongo.dto.BookingDto;
import com.Mongo.EjemploMongo.model.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> getAll();
    Booking findById(String id);
    Booking create(BookingDto bookingDto);
    Booking update(String id,BookingDto bookingDto);
    Boolean deleteBooking(String id);
}
