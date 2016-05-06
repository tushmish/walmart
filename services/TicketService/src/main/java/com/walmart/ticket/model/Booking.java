package com.walmart.ticket.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Bean to store booking details.
 *
 * @author tushar
 */

@NamedNativeQueries({@NamedNativeQuery(name = "FIND_AVAILABLE_SEATS",
    query = "select level_id, row_id, column_id from seat s where s.id not in ( "
        + "select seat_id from booking_seat join booking on  booking.id = booking_seat.booking_id "
        + "join event on booking.event_id = event.id  "
        + "where event.name = ? ) and s.level_id = ?",
    resultClass = Booking.class)})

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {"id", "username", "status"})
@Entity
@Table(name = "BOOKING", schema = "WALMART")
public class Booking extends BaseEntity implements Serializable {

  /**
   * booking status.
   * 
   * @author Kalpana
   */
  public enum BOOKING_STATUS {
    AVAILABLE, ON_HOLD, RESERVED
  };

  // -------- class variables ----------

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1747732848324026486L;

  /** row #. **/
  @JsonProperty
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEAT")
  @SequenceGenerator(name = "SEQ_SEAT", sequenceName = "SEQ_SEAT", allocationSize = 1)
  private int id;

  /** customer who booked the seats. **/
  @JsonProperty
  @Column(name = "USER_NAME", nullable = false, unique = true, updatable = false)
  private String username;

  /** status. **/
  @JsonProperty
  @JsonInclude(Include.NON_EMPTY)
  @Column(name = "STATUS", nullable = false, unique = false, updatable = true)
  private String status;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "BOOKING_SEAT", catalog = "walmart",
      joinColumns = {@JoinColumn(name = "BOOKING_ID", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "SEAT_ID", nullable = false, updatable = false)})
  private Set<Seat> seats = new HashSet<Seat>(0);

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "EVENT_ID", nullable = false)
  private Event event;

  // -------- methods ------------------

  // -------- getters and setters ------

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username.
   *
   * @param username
   *          the new username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status
   *          the new status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  public Set<Seat> getSeats() {
    return seats;
  }

  public void setSeats(Set<Seat> seats) {
    this.seats = seats;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }


}
