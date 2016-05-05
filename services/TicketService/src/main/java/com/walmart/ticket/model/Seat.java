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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@JsonPropertyOrder(value = {"id", "levelId", "rowId", "columnId"})
@Entity
@Table(name = "SEAT", schema = "WALMART")
public class Seat implements Comparable<Seat>, Serializable {

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
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "LEVEL_ID", nullable = false)
  private SeatCategory levelId;

  /** row #. **/
  @JsonProperty
  @Column(name = "ROW_ID", nullable = false, unique = true, updatable = false)
  private int rowId;

  /** seat #. **/
  @JsonProperty
  @Column(name = "COLUMN_ID", nullable = false, unique = true, updatable = false)
  private int columnId;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "seats")
  private Set<Booking> bookings = new HashSet<Booking>(0);

  // -------- methods ------------------


  // -------- getters and setters ------

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the level id.
   *
   * @return the level id
   */
  public SeatCategory getLevelId() {
    return levelId;
  }

  /**
   * Sets the level id.
   *
   * @param levelId the new level id
   */
  public void setLevelId(final SeatCategory levelId) {
    this.levelId = levelId;
  }

  /**
   * Gets the row id.
   *
   * @return the row id
   */
  public int getRowId() {
    return rowId;
  }

  /**
   * Sets the row id.
   *
   * @param rowId the new row id
   */
  public void setRowId(int rowId) {
    this.rowId = rowId;
  }

  @Override
  public int compareTo(Seat o) {
    // TODO Auto-generated method stub
    return 0;
  }

  public int getColumnId() {
    return columnId;
  }

  public void setColumnId(int columnId) {
    this.columnId = columnId;
  }

  public Set<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }


}
