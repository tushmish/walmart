package com.walmart.ticket.service.impl;

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
import com.walmart.ticket.impl.SeatRepositoryImpl;
import com.walmart.ticket.impl.TicketServiceImpl;
import com.walmart.ticket.model.Booking;
import com.walmart.ticket.model.Booking.BOOKING_STATUS;
import com.walmart.ticket.model.Event;
import com.walmart.ticket.model.Seat;
import com.walmart.ticket.model.SeatCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, HibernateConfiguration.class})
@WebAppConfiguration
public class TicketServiceImplTest {

  /** road service. **/
  @Autowired
  private TicketServiceImpl ticketServiceImpl;

  @Autowired
  private SeatRepositoryImpl seatRepositoryImpl;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void test() {
    Booking booking = new Booking();
    booking.setStatus(BOOKING_STATUS.ON_HOLD.name());
    booking.setUsername("test-user");

    Event event = new Event();
    event.setName("opera");
    // event.setId(1);

    booking.setEvent(event);

    SeatCategory s = new SeatCategory();
    s.setName("Level 1");
    // s.setId(67);

    Seat seat1 = new Seat();
    seat1.setLevelId(s);
    // seat1.setId(43879);

    Seat seat2 = new Seat();
    seat2.setLevelId(s);

    Set<Seat> seats = new HashSet<Seat>();
    seats.add(seat1);
    // seats.add(seat2);

    booking.setSeats(seats);

    try {

      ticketServiceImpl.insert(booking);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
