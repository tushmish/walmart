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
import com.walmart.ticket.SeatRepository;
import com.walmart.ticket.TicketService;
import com.walmart.ticket.model.Booking;
import com.walmart.ticket.model.Seat;

@Service("ticketServiceImpl")
@Transactional
public class TicketServiceImpl implements TicketService {

  @Autowired
  private SeatRepository<Seat> seatRepository;

  @Autowired
  private BookingRepository<Booking> bookingRepository;

  @Override
  @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED,
      rollbackFor = Exception.class, readOnly = true)
  public int numSeatsAvailable(Optional<Integer> venueLevel) {
    return bookingRepository.findAvailableSeats(venueLevel.get());
  }

  // TODO validate seat
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,
      timeout = 300)
  public Booking findAndHoldSeats(Set<Seat> seats, Optional<Integer> minLevel,
      Optional<Integer> maxLevel, String customerEmail) {

    // insert a new booking
    Booking booking = new Booking();
    booking.setUsername(customerEmail);
    booking.setStatus(Booking.BOOKING_STATUS.ON_HOLD.name());
    booking.setCreatedOn(new Date());
    booking.setSeats(seats);
    bookingRepository.insert(booking);
    return booking;
  }

  // TODO validate seat
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,
      timeout = 300)
  public Booking reserveSeats(Booking booking, String customerEmail) {
    booking.setUsername(customerEmail);
    booking.setStatus(Booking.BOOKING_STATUS.RESERVED.name());
    booking.setUpdatedOn(new Date());
    return bookingRepository.update(booking);
  }



  // TODO delete
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,
      timeout = 300)
  public void insert(Booking booking) {
    seatRepository.insert(booking.getSeats());
    bookingRepository.insert(booking);
  }

  @Override
  public Set<Seat> findAvailableSeats(Optional<Integer> venueLevel) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Booking holdSeats(Set<Seat> seats, String customerEmail) {
    // TODO Auto-generated method stub
    return null;
  }

}


