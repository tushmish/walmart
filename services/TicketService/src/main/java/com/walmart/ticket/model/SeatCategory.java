package com.walmart.ticket.model;

import java.io.Serializable;
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
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

// TODO: Auto-generated Javadoc
/**
 * Bean to store seat details.
 *
 * @author tushar
 */

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {"id", "name", "rowCount", "seatCount", "price"})
@Entity
@Table(name = "SEAT_CATEGORY", schema = "WALMART")
public class SeatCategory implements Comparable<SeatCategory>, Serializable {

  // -------- class variables ----------

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4528744008437244639L;

  /** The id. */
  @JsonProperty
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEAT")
  @SequenceGenerator(name = "SEQ_SEAT", sequenceName = "SEQ_SEAT", allocationSize = 1)
  private int id;

  /** row #. **/
  @JsonProperty
  @Column(name = "NAME", nullable = false, unique = true, updatable = true)
  private String name;

  /** row #. **/
  @JsonProperty
  @Column(name = "ROW_COUNT", nullable = false, unique = false, updatable = true)
  private int rowCount;

  /** seat #. **/
  @JsonProperty
  @Column(name = "SEAT_COUNT", nullable = false, unique = false, updatable = true)
  private int seatCount;

  /** The price. */
  @JsonProperty
  @Column(name = "PRICE", nullable = false, unique = false, updatable = true)
  private int price;

  /** The seats. */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "levelId")
  private Set<Seat> seats = new HashSet<Seat>(0);

  // -------- methods ------------------
  /**
   * Uses Guava to assist in providing hash code.
   *
   * @return My hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(getId(), getName());
  }

  /**
   * Using Guava to compare provided object to me for equality.
   *
   * @param obj Object to be compared to me for equality.
   * @return {@code true} if provided object is considered equal to me or {@code false} if provided
   *         object is not considered equal to me.
   */
  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final SeatCategory other = (SeatCategory) obj;
    return Objects.equal(this.getId(), other.getId())
        && Objects.equal(this.getName(), other.getName());
  }

  /**
   * Using Guava to compare provided object to me for sorting.
   *
   * @param other the other object
   * @return -1, if less than the other object 0, if objects are same +1, if the object is greater
   *         than other object
   */
  @Override
  public final int compareTo(final SeatCategory other) {
    return ComparisonChain.start().compare(getId(), other.getId())
        .compare(getName(), other.getName()).result();
  }

  /**
   * Method using Guava to provide String representation of an instance.
   *
   * @return string representation of an instance.
   */
  @Override
  public String toString() {
    return Objects.toStringHelper(this).addValue(getId()).addValue(getName()).toString();
  }

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
   * @param id the new id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the row count.
   *
   * @return the row count
   */
  public int getRowCount() {
    return rowCount;
  }

  /**
   * Sets the row count.
   *
   * @param rowCount the new row count
   */
  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  /**
   * Gets the seat count.
   *
   * @return the seat count
   */
  public int getSeatCount() {
    return seatCount;
  }

  /**
   * Sets the seat count.
   *
   * @param seatCount the new seat count
   */
  public void setSeatCount(int seatCount) {
    this.seatCount = seatCount;
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Sets the price.
   *
   * @param price the new price
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * Gets the seats.
   *
   * @return the seats
   */
  public Set<Seat> getSeats() {
    return seats;
  }

  /**
   * Sets the seats.
   *
   * @param seats the new seats
   */
  public void setSeats(Set<Seat> seats) {
    this.seats = seats;
  }

}
