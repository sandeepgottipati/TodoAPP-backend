package com.sandeep.TodoApp.Todo.repository;

import com.sandeep.TodoApp.Todo.Todo;
import com.sandeep.TodoApp.Todo.TodoDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaController {
    private TodoDaoService todoDaoService;
    private TodoRepository todoRepository;
    public TodoJpaController(TodoDaoService todoDaoService,TodoRepository todoRepository) {
        this.todoRepository=todoRepository;
        this.todoDaoService = todoDaoService;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
//        return todoDaoService.findByUserName(username);
        return todoRepository.findByUsername(username);
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
        return todoRepository.findById(id).get();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping(path = "/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId(null);
       return todoRepository.save(todo);
        //Todo createdTodo = todoDaoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());

    }
}
