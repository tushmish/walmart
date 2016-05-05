package com.walmart.ticket.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * common properties to be used across the entities.
 *
 * @author tushar
 */
public class BaseEntity {

  // -------- class variables ----------
  /** store the user id who added this entity. This cannot be empty. **/
  @JsonProperty
  @JsonInclude(Include.NON_EMPTY)
  private String createdBy = "";

  /** store the user id who added this entity. This cannot be empty. **/
  @JsonProperty
  @JsonInclude(Include.NON_EMPTY)
  private Date createdOn;

  /** store the user id who updated this entity. **/
  @JsonProperty
  @JsonInclude(Include.NON_EMPTY)
  private String updatedBy = "";

  /** last modified date. **/
  @JsonProperty
  // @Version
  private Date updatedOn;

  /** store the user id who deleted this entity. This cannot be empty. **/
  @JsonProperty
  @JsonInclude(Include.NON_EMPTY)
  private String deletedBy = "";

  /** store the date on which the entity was deleted. **/
  @JsonProperty
  private Date deletedOn;

  // -------- getters and setters ------
  /**
   * Gets the created by.
   *
   * @return the created by
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Sets the created by.
   *
   * @param createdBy the new created by
   */
  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }



  /**
   * Gets the created on.
   *
   * @return the created on
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Sets the created on.
   *
   * @param createdOn the new created on
   */
  public void setCreatedOn(final Date createdOn) {
    this.createdOn = createdOn;
  }

  /**
   * Gets the updated by.
   *
   * @return the updated by
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Sets the updated by.
   *
   * @param updatedBy the new updated by
   */
  public void setUpdatedBy(final String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * Gets the updated on.
   *
   * @return the updated on
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Sets the updated on.
   *
   * @param updatedOn the new updated on
   */
  public void setUpdatedOn(final Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  /**
   * Gets the deleted by.
   *
   * @return the deletedBy
   */
  public String getDeletedBy() {
    return deletedBy;
  }

  /**
   * Sets the deleted by.
   *
   * @param deletedBy the deletedBy to set
   */
  public void setDeletedBy(final String deletedBy) {
    this.deletedBy = deletedBy;
  }

  /**
   * Gets the deleted on.
   *
   * @return the deletedOn
   */
  public Date getDeletedOn() {
    return deletedOn;
  }

  /**
   * Sets the deleted on.
   *
   * @param deletedOn the deletedOn to set
   */
  public void setDeletedOn(final Date deletedOn) {
    this.deletedOn = deletedOn;
  }

}
