package com.Mongo.EjemploMongo.model;

import com.Mongo.EjemploMongo.dto.BookingDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "Booking_Collection")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idBooking;
    private String bookingType;
    private Boolean reserved;
    @JsonFormat(timezone = "America/Bogota")
    private LocalDate bookingStartDate;
    @JsonFormat(timezone = "America/Bogota")
    private LocalDate bookingEndDate;


    public Booking() {
    }

    public Booking(String idBooking, String bookingType, Boolean reserved, LocalDate bookingStartDate, LocalDate bookingEndDate) {
        this.idBooking = idBooking;
        this.bookingType = bookingType;
        this.reserved = reserved;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
    }

    public Booking (BookingDto bookingDto){
        this.bookingType = bookingDto.getBookingType();
        this.reserved = bookingDto.getReserved();
        this.bookingStartDate= bookingDto.getBookingStartDate();
        this.bookingEndDate = bookingDto.getBookingEndDate();
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
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

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", reserved=" + reserved +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(idBooking, booking.idBooking) && Objects.equals(bookingType, booking.bookingType) && Objects.equals(reserved, booking.reserved) && Objects.equals(bookingStartDate, booking.bookingStartDate) && Objects.equals(bookingEndDate, booking.bookingEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, bookingType, reserved, bookingStartDate, bookingEndDate);
    }
}
