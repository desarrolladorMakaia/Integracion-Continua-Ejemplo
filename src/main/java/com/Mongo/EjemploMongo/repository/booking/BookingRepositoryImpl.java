package com.Mongo.EjemploMongo.repository.booking;

import com.Mongo.EjemploMongo.dto.BookingDto;
import com.Mongo.EjemploMongo.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookingRepositoryImpl implements BookingRepository{

    private final BookingMongoRepository bookingMongoRepository;

    public BookingRepositoryImpl(BookingMongoRepository bookingMongoRepository) {
        this.bookingMongoRepository = bookingMongoRepository;
    }

    @Override
    public List<Booking> getAll() {
        return bookingMongoRepository.findAll().size()>0 ? bookingMongoRepository.findAll():null;
    }

    @Override
    public Booking findById(String id) {
        return bookingMongoRepository.findById(id).isPresent() ? bookingMongoRepository.findById(id).get():null;
    }

    @Override
    public Booking create(BookingDto bookingDto) {
        Booking booking = new Booking(bookingDto);
        return bookingMongoRepository.save(booking);

    }

    @Override
    public Booking update(String id, BookingDto bookingDto) {
        Booking bookingFound = findById(id);
        if(bookingFound!=null){
            bookingFound.setBookingType(bookingDto.getBookingType());
            bookingFound.setReserved(bookingDto.getReserved());
            bookingFound.setBookingStartDate(bookingDto.getBookingStartDate());
            bookingFound.setBookingEndDate(bookingDto.getBookingEndDate());
            return bookingMongoRepository.save(bookingFound);
        }
        return null;
    }

    @Override
    public Boolean deleteBooking(String id) {
        Booking bookingFound = findById(id);
        if(bookingFound!=null){
            bookingMongoRepository.delete(bookingFound);
            return true;
        }
        return false;
    }

}


