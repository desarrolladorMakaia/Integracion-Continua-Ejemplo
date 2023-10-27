package com.Mongo.EjemploMongo.controller;

import com.Mongo.EjemploMongo.dto.BookingDto;
import com.Mongo.EjemploMongo.model.Booking;
import com.Mongo.EjemploMongo.service.booking.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
        public ResponseEntity<List<Booking>> getAll() {
            List<Booking> bookingFound = bookingService.getAll();
            if (bookingFound.size() > 0) {
                return new ResponseEntity<>(bookingFound, HttpStatus.OK);
            } else {
                return new ResponseEntity("Booking not found", HttpStatus.NOT_FOUND);
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<Booking> findById(@PathVariable String id) {
            Booking booking = bookingService.findById(id);
            if (booking != null) {
                return new ResponseEntity<>(booking, HttpStatus.OK);
            } else {
                return new ResponseEntity("the id" + id + "is not found", HttpStatus.NOT_FOUND);
            }

        }
        @PostMapping
        public ResponseEntity<Booking> create(@RequestBody BookingDto bookingDto){
            Booking booking = bookingService.create(bookingDto);
            if(booking!=null){
                return new ResponseEntity<>(booking ,HttpStatus.CREATED);
            }else{
                return new ResponseEntity("Error creating user",HttpStatus.CONFLICT);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody BookingDto bookingDto){
            Booking booking = bookingService.update(id, bookingDto);
            if(booking!=null){
                return new ResponseEntity<>(booking, HttpStatus.OK);
            }else{
                return new ResponseEntity("Error updatig booking", HttpStatus.NOT_FOUND);
            }
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Boolean> deleteBooking(@PathVariable String id){
            Boolean isDeleted = bookingService.deleteBooking(id);
            if(isDeleted){
                return new ResponseEntity<>(isDeleted ,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
            }

        }







    }

