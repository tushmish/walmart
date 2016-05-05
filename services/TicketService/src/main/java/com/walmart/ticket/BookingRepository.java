package com.walmart.ticket;

import java.util.List;

import com.walmart.ticket.model.Seat;

public interface BookingRepository<Booking> extends BaseRepository<Booking> {

  List<Seat> findSeatsOnHold();

  List<Seat> findReservedSeats();

  int findAvailableSeats();

  int findAvailableSeats(int level);

}


