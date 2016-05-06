package com.walmart.ticket;

import java.util.List;

import com.walmart.ticket.model.Seat;

/**
 * Repository to book tickets.
 *
 * @param <Booking>
 *          the generic type
 */
public interface BookingRepository<Booking> extends BaseRepository<Booking> {

  /**
   * Find seats on hold.
   *
   * @return the list
   */
  List<Seat> findSeatsOnHold();

  /**
   * Find reserved seats.
   *
   * @return the list
   */
  List<Seat> findReservedSeats();

  /**
   * Find available seats.
   *
   * @return the int
   */
  int findAvailableSeats();

  /**
   * Find available seats.
   *
   * @param level
   *          the level
   * @return the int
   */
  int findAvailableSeats(int level);

}


