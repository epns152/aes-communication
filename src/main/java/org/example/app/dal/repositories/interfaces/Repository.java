package org.example.app.dal.repositories.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T, U> {

  void save(T obj);

  Optional<T> findById(U id);
  Optional<T> findByPredicate(Predicate<T> predicate);

  List<T> findAll();

  void update(T obj);

  void delete(T obj);
}
