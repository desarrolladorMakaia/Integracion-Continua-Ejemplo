package com.Mongo.EjemploMongo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;


    private String bookingType;
    private Boolean reserved;

    private LocalDate bookingStartDate;

    private LocalDate bookingEndDate;


    public BookingDto() {
    }

    public BookingDto(String bookingType, Boolean reserved, LocalDate bookingStartDate, LocalDate bookingEndDate) {
        this.bookingType = bookingType;
        this.reserved = reserved;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public LocalDate getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(LocalDate bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(LocalDate bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }


}













