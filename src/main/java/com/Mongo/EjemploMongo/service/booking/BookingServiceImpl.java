package com.Mongo.EjemploMongo.service.booking;

import com.Mongo.EjemploMongo.dto.BookingDto;
import com.Mongo.EjemploMongo.model.Booking;
import com.Mongo.EjemploMongo.repository.booking.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

   private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public List<Booking> getAll() {
        return bookingRepository.getAll();
    }

    @Override
    public Booking findById(String id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking create(BookingDto bookingDto) {
        return bookingRepository.create(bookingDto);
    }

    @Override
    public Booking update(String id, BookingDto bookingDto) {
        return bookingRepository.update(id, bookingDto);
    }

    @Override
    public Boolean deleteBooking(String id) {
        return bookingRepository.deleteBooking(id);
    }
}
