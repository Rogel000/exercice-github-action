package org.example.exercice6spring.service;

import org.example.exercice6spring.dao.ITodoRepository;
import org.example.exercice6spring.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final ITodoRepository todoRepository;

    public TodoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public List<Todo> findByIsValidated(boolean status) {
        return todoRepository.findByIsValidated(status);
    }

    public Todo changeStatus(long id) {
        Todo todo = findById(id);
        todo.setIsValidated(!todo.getIsValidated());
        todoRepository.save(todo);
        return todo;
    }
}
