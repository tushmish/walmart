package com.walmart.ticket.impl;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.walmart.ticket.BookingRepository;
import com.walmart.ticket.TicketService;
import com.walmart.ticket.model.Booking;
import com.walmart.ticket.model.Seat;

/**
 * implementation class for ticket service .
 */
@Service("ticketServiceImpl")
@Transactional
public class TicketServiceImpl implements TicketService {

  /** The booking repository. */
  @Autowired
  private BookingRepository<Booking> bookingRepository;

  /**
   * Seats in the requested level that are neither held nor reserved.
   *
   * @param venueLevel
   *          a numeric venue level identifier to limit the search
   * @return the number of tickets available on the provided level
   */
  @Override
  public Set<Seat> findAvailableSeats(Optional<Integer> venueLevel) {
    // return bookingRepository.findAvailableSeats(venueLevel.get());
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.TicketService#numSeatsAvailable(java.util.Optional)
   */
  @Override
  @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED,
      rollbackFor = Exception.class, readOnly = true)
  public int numSeatsAvailable(Optional<Integer> venueLevel) {
    return bookingRepository.findAvailableSeats(venueLevel.get());
  }

  /**
   * Find and hold the best available seats for a customer.
   *
   * @param seats
   *          the number of seats to find and hold
   * @param customerEmail
   *          unique identifier for the customer
   * @return a SeatHold object identifying the specific seats and related information
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,
      timeout = 300)
  public Booking holdSeats(Set<Seat> seats, String customerEmail) {
    Booking booking = null;
    synchronized (this) {
      // insert a new booking
      booking = new Booking();
      booking.setUsername(customerEmail);
      booking.setStatus(Booking.BOOKING_STATUS.ON_HOLD.name());
      booking.setCreatedOn(new Date());
      booking.setSeats(seats);
      bookingRepository.insert(booking);
    }
    return booking;
  }

  /**
   * Commit seats held for a specific customer.
   *
   * @param booking
   *          the seat hold identifier
   * @param customerEmail
   *          the email address of the customer to which the seat hold is assigned
   * @return a reservation confirmation code
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,
      timeout = 300)
  public Booking reserveSeats(Booking booking, String customerEmail) {
    Booking booked = null;
    synchronized (this) {
      booking.setUsername(customerEmail);
      booking.setStatus(Booking.BOOKING_STATUS.RESERVED.name());
      booking.setUpdatedOn(new Date());
      booked = bookingRepository.update(booking);
    }
    return booked;
  }



  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.TicketService#findAndHoldSeats(int, java.util.Optional,
   * java.util.Optional, java.lang.String)
   */
  @Override
  public Booking findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
      Optional<Integer> maxLevel, String customerEmail) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.TicketService#reserveSeats(int, java.lang.String)
   */
  @Override
  public String reserveSeats(int seatHoldId, String customerEmail) {
    // TODO Auto-generated method stub
    return null;
  }

}


