package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Booking;
import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.module.User;
import edu.miu.cs.cs425.webapp.homib_tcms.repository.IBookingRepository;
import edu.miu.cs.cs425.webapp.homib_tcms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private IBookingRepository bookingRepository;
@Autowired
    public BookingServiceImpl(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public List<Booking> fetchAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
