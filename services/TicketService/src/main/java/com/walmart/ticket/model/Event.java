package com.walmart.ticket.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@JsonPropertyOrder(value = {"id", "showTime", "name", "description"})
@Entity
@Table(name = "EVENT", schema = "WALMART")
public class Event implements Comparable<Event>, Serializable {

  // -------- class variables ----------

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4528744008437244639L;

  @JsonProperty
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEAT")
  @SequenceGenerator(name = "SEQ_SEAT", sequenceName = "SEQ_SEAT", allocationSize = 1)
  private int id;

  /** row #. **/
  @JsonProperty
  @Column(name = "SHOW_TIME", nullable = true, unique = true, updatable = true)
  private Timestamp showTime;

  /** row #. **/
  @JsonProperty
  @Column(name = "NAME", nullable = false, unique = true, updatable = true)
  private String name;

  /** seat #. **/
  @JsonProperty
  @Column(name = "DESCRIPTION", nullable = true, unique = false, updatable = true)
  private String description;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
  private Set<Booking> bookings = new HashSet<Booking>(0);

  // -------- methods ------------------


  // -------- getters and setters ------

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Timestamp getShowTime() {
    return showTime;
  }

  public void setShowTime(Timestamp showTime) {
    this.showTime = showTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int compareTo(Event o) {
    // TODO Auto-generated method stub
    return 0;
  }

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

}
