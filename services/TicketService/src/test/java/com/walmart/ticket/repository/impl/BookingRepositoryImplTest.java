/**
 * 
 */
package com.walmart.ticket.repository.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.walmart.ticket.config.AppConfig;
import com.walmart.ticket.config.HibernateConfiguration;
import com.walmart.ticket.impl.BookingRepositoryImpl;
import com.walmart.ticket.model.Booking;
import com.walmart.ticket.model.Booking.BOOKING_STATUS;
import com.walmart.ticket.model.Seat;
import com.walmart.ticket.model.SeatCategory;

/**
 * @author Kalpana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, HibernateConfiguration.class})
@WebAppConfiguration
public class BookingRepositoryImplTest {

  /** road service. **/
  @Autowired
  private BookingRepositoryImpl bookingRepositoryImpl;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  /**
   * Test method for
   * {@link com.walmart.ticket.impl.BookingRepositoryImpl#insert(java.lang.Object)}.
   */
  @Test
  public void testInsertBooking() {
    Booking booking = new Booking();
    booking.setStatus(BOOKING_STATUS.ON_HOLD.name());
    booking.setUsername("test-user");

    SeatCategory s = new SeatCategory();
    s.setName("orchestra");

    Seat seat1 = new Seat();
    seat1.setLevelId(s);
    seat1.setRowId(1);
    seat1.setColumnId(1);

    Seat seat2 = new Seat();
    seat1.setLevelId(s);
    seat1.setRowId(1);
    seat1.setColumnId(2);

    Set<Seat> seats = new HashSet<Seat>();
    seats.add(seat1);
    seats.add(seat2);

    booking.setSeats(seats);

    bookingRepositoryImpl.insert(booking);
  }

}
