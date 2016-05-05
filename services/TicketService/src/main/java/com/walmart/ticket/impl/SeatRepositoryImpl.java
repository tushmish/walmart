package com.walmart.ticket.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.walmart.ticket.SeatRepository;

@Repository("seatRepositoryImpl")
public class SeatRepositoryImpl<Seat> extends BaseDao implements SeatRepository<Seat> {

  @Override
  public void insert(final Set<Seat> entities) {
    for (Seat seat : entities) {
      persist(seat);
    }

  }

  @Override
  public List<Seat> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Seat> findAll(String criteria) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Seat> find(final String criteria) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Seat update(final Seat entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insert(Seat entity) {
    persist(entity);

  }

}


