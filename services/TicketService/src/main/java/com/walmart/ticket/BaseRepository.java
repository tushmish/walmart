package com.walmart.ticket;

import java.util.List;
import java.util.Set;

public interface BaseRepository<T> {

  void insert(T entity);

  void insert(Set<T> entities);

  List<T> findAll();

  List<T> findAll(String criteria);

  List<T> find(String criteria);

  T update(T entity);

}


