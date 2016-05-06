package com.walmart.ticket;

import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.walmart.ticket.model.Booking;
import com.walmart.ticket.model.Seat;

/**
 * Controller for handling services on booking a show.
 *
 * @author tushar
 */
@RestController("ticketController")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class TicketController {

  // -------- class variables ----------

  /** user service. **/
  @Autowired
  private TicketService service;

  /** message source. **/
  @Autowired
  private MessageSource messageSource;

  // -------- methods ------------------


  /**
   * finds all the available seats. Optionally, can find seats at a specific level.
   * 
   * @param name
   *          the show name
   * @param showTime
   *          the show time
   * @param seatCategory
   *          the level of seat. the seat category
   * @return list of all available seats.
   */
  @RequestMapping(value = "/shows/{name}/seats", method = RequestMethod.GET)
  public Object findAvailableSeats(@PathVariable("name") final String name,
      @RequestParam(value = "showTime", required = false, defaultValue = "") final String showTime,
      @RequestParam(value = "seatCategory", required = false,
          defaultValue = "") final int seatCategory) {

    service.findAvailableSeats(Optional.ofNullable(seatCategory));
    final String userMessage =
        this.messageSource.getMessage("message.seats.find.success", new Object[] {}, Locale.US);

    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new ResponseEntity<String>(userMessage, responseHeaders, HttpStatus.OK);
  }

  /**
   * marks seats on hold.
   * 
   * @param name
   *          the show name
   * @param seats
   *          the show time
   * @return booking containing seats put on hold.
   */
  @RequestMapping(value = "/shows/{name}/seats", method = RequestMethod.POST)
  public Object markSeatsOnHold(@PathVariable("name") final String name,
      @RequestBody(required = true) final Set<Seat> seats,
      @RequestBody(required = true) final String email) {

    final Booking booking = service.holdSeats(seats, email);
    final String userMessage =
        this.messageSource.getMessage("message.seats.hold.success", new Object[] {}, Locale.US);

    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new ResponseEntity<Booking>(booking, responseHeaders, HttpStatus.CREATED);
  }

  /**
   * marks seats as reserved.
   * 
   * @param name
   *          the show name
   * @param booking
   *          booking details
   * @return booking containing reserved seats.
   */
  @RequestMapping(value = "/shows/{name}/seats", method = RequestMethod.PUT)
  public Object reserveSeats(@PathVariable("name") final String name,
      @RequestBody(required = true) final Booking booking,
      @RequestBody(required = true) final String email) {

    final Booking reserveSeats = service.reserveSeats(booking, email);
    final String userMessage =
        this.messageSource.getMessage("message.seats.reserved.success", new Object[] {}, Locale.US);

    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new ResponseEntity<Booking>(reserveSeats, responseHeaders, HttpStatus.OK);
  }

}
