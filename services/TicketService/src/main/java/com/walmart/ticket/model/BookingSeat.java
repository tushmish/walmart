package com.walmart.ticket.model;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Bean to store seat details.
 *
 * @author tushar
 */

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {"bookingId", "seatId", "eventId"})
public class BookingSeat implements Comparable<BookingSeat>, Serializable {

  // -------- class variables ----------

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4528744008437244639L;

  /** row #. **/
  @JsonProperty
  @Column(name = "BOOKING_ID", nullable = false, unique = true, updatable = false)
  private int bookingId;

  /** row #. **/
  @JsonProperty
  @Column(name = "SEAT_ID", nullable = false, unique = true, updatable = false)
  private int seatId;

  /** seat #. **/
  @JsonProperty
  @Column(name = "EVENT_ID", nullable = true, unique = false, updatable = false)
  private int eventId;

  // -------- methods ------------------


  // -------- getters and setters ------


  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  public int getSeatId() {
    return seatId;
  }

  public void setSeatId(int seatId) {
    this.seatId = seatId;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  @Override
  public int compareTo(BookingSeat o) {
    // TODO Auto-generated method stub
    return 0;
  }



}
