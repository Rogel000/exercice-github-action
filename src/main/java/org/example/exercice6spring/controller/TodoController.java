package org.example.exercice6spring.controller;

import org.example.exercice6spring.entity.Todo;
import org.example.exercice6spring.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping ("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return ResponseEntity.ok(service.save(todo));
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok("success");
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todoRequest){
        return ResponseEntity.ok(service.save(todoRequest));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Todo>> findByStatus(@PathVariable("status") boolean status){
        return ResponseEntity.ok(service.findByIsValidated(status));
    }

    //changer le status de la to do
    @PutMapping("/change-status/{id}")
    public ResponseEntity<Todo> changeStatus(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.changeStatus(id));

    }
}
