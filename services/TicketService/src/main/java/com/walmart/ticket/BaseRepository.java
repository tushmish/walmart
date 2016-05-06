package com.walmart.ticket;

import java.util.List;
import java.util.Set;

/**
 * Base interface for CRUD operations on any entity..
 *
 * @param <T>
 *          the generic type
 */
public interface BaseRepository<T> {

  /**
   * Insert.
   *
   * @param entity
   *          the entity
   */
  void insert(T entity);

  /**
   * Insert.
   *
   * @param entities
   *          the entities
   */
  void insert(Set<T> entities);

  /**
   * Find all.
   *
   * @return the list
   */
  List<T> findAll();

  /**
   * Find all.
   *
   * @param criteria
   *          the criteria
   * @return the list
   */
  List<T> findAll(String criteria);

  /**
   * Find.
   *
   * @param criteria
   *          the criteria
   * @return the list
   */
  List<T> find(String criteria);

  /**
   * Update.
   *
   * @param entity
   *          the entity
   * @return the t
   */
  T update(T entity);

}


