package com.walmart.ticket;

import java.util.Optional;
import java.util.Set;

import com.walmart.ticket.model.Booking;
import com.walmart.ticket.model.Seat;

/**
 * Base interface to handle requests to book tickets.
 * 
 * @author tushar
 */
public interface TicketService {
  /**
   * The number of seats in the requested level that are neither held nor reserved.
   *
   * @param venueLevel
   *          a numeric venue level identifier to limit the search
   * @return the number of tickets available on the provided level
   */
  int numSeatsAvailable(Optional<Integer> venueLevel);

  // As I understand it from a perspective of Kiosk or any UI screen - e.g selecting seats while
  // checking-in, the user must be shown all the seats at all the levels. Of course, with a option
  // to filter down based on levels.
  //
  // Changed - method return type to set of seats as it also provides the count of seats.

  /**
   * Seats in the requested level that are neither held nor reserved.
   *
   * @param venueLevel
   *          a numeric venue level identifier to limit the search
   * @return the number of tickets available on the provided level
   */
  Set<Seat> findAvailableSeats(Optional<Integer> venueLevel);

  /**
   * Find and hold the best available seats for a customer.
   *
   * @param numSeats
   *          the number of seats to find and hold
   * @param minLevel
   *          the minimum venue level
   * @param maxLevel
   *          the maximum venue level
   * @param customerEmail
   *          unique identifier for the customer
   * @return a SeatHold object identifying the specific seats and related information
   */
  Booking findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel,
      String customerEmail);

  // Once the user can see and select the seats, the exact count and seat metadata are passed to
  // change its state to on_hold.
  // finding a seat between levels should be a part of GET operation. The levels can be additional
  // filters.
  // to which level it belongs to is the metadata about seat and is uniue about it.
  //
  // Changed - method signature to accept only booking. Booking has a ManyToMany relationship with
  // seats. The actual state change is of Booking from available -> on hold -> reserved.And in that
  // order.

  /**
   * Find and hold the best available seats for a customer.
   *
   * @param seats
   *          the number of seats to find and hold
   * @param customerEmail
   *          unique identifier for the customer
   * @return a SeatHold object identifying the specific seats and related information
   */
  Booking holdSeats(Set<Seat> seats, String customerEmail);

  /**
   * Commit seats held for a specific customer.
   *
   * @param seatHoldId
   *          the seat hold identifier
   * @param customerEmail
   *          the email address of the customer to which the seat hold is assigned
   * @return a reservation confirmation code
   */
  String reserveSeats(int seatHoldId, String customerEmail);

  // A user may take time to reserve tickets. Keeping the booking information as TTL cach or in a
  // transient state will likely prevent a database call.
  //
  // Changed - method parameter to booking instead of booking id.
  /**
   * Commit seats held for a specific customer.
   *
   * @param booking
   *          the seat hold identifier
   * @param customerEmail
   *          the email address of the customer to which the seat hold is assigned
   * @return a reservation confirmation code
   */
  Booking reserveSeats(Booking booking, String customerEmail);

}


