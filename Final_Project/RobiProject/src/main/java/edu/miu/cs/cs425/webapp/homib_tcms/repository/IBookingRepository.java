package edu.miu.cs.cs425.webapp.homib_tcms.repository;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookingRepository extends JpaRepository<Booking, Long> {
}
