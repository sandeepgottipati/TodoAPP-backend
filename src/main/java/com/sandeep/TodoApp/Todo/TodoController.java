package com.sandeep.TodoApp.Todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TodoController {
    private TodoDaoService todoDaoService;

    public TodoController(TodoDaoService todoDaoService) {
        this.todoDaoService = todoDaoService;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoDaoService.findByUserName(username);
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
        return todoDaoService.findById(id);
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        todoDaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todoDaoService.updateTodo(todo);
        return todo;
    }

    @PostMapping(path = "/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoDaoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return createdTodo;
    }
}
