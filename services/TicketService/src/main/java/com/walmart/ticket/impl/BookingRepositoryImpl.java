package com.walmart.ticket.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.walmart.ticket.BookingRepository;
import com.walmart.ticket.model.Seat;

/**
 * The Class BookingRepository implementation.
 *
 * @param <Booking>
 *          the generic type
 */
@Repository("bookingRepositoryImpl")
public class BookingRepositoryImpl<Booking> extends BaseRepository
    implements BookingRepository<Booking> {

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BaseRepository#insert(java.util.Set)
   */
  @Override
  public void insert(final Set<Booking> entities) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BaseRepository#findAll()
   */
  @Override
  public List<Booking> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BaseRepository#findAll(java.lang.String)
   */
  @Override
  public List<Booking> findAll(String criteria) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BaseRepository#find(java.lang.String)
   */
  @Override
  public List<Booking> find(final String criteria) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BaseRepository#update(java.lang.Object)
   */
  @Override
  public Booking update(final Booking booking) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BookingRepository#findSeatsOnHold()
   */
  @Override
  public List<Seat> findSeatsOnHold() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BookingRepository#findReservedSeats()
   */
  @Override
  public List<Seat> findReservedSeats() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BookingRepository#findAvailableSeats()
   */
  @Override
  public int findAvailableSeats() {
    Query query = getSession().getNamedQuery("FIND_AVAILABLE_SEATS");
    List<Seat> list = query.list();
    Optional<List<Seat>> seats = Optional.of(list);
    return seats.get().size();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BookingRepository#findAvailableSeats(int)
   */
  // assumption -- levels are numbers and incremental
  @Override
  public int findAvailableSeats(int level) {
    Query query =
        getSession().getNamedQuery("FIND_AVAILABLE_SEATS_AT_LEVEL").setInteger("levelId", level);
    List<Seat> list = query.list();
    Optional<List<Seat>> seats = Optional.of(list);
    return seats.get().size();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.walmart.ticket.BaseRepository#insert(java.lang.Object)
   */
  @Override
  public void insert(Booking booking) {
    persist(booking);
  }


}


