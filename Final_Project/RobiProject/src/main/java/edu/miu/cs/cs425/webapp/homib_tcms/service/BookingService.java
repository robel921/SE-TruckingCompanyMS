package edu.miu.cs.cs425.webapp.homib_tcms.service;


import edu.miu.cs.cs425.webapp.homib_tcms.module.Booking;
import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.module.User;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    public abstract List<Booking> fetchAllBookings();
    public abstract Booking saveBooking(Booking booking);
    public abstract Booking getBookingById(Long bookingId);
    public abstract void deleteBookingById(Long bookingId);
}
