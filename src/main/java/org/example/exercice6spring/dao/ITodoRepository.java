package org.example.exercice6spring.dao;

import org.example.exercice6spring.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByIsValidated(boolean isValidated);


}
