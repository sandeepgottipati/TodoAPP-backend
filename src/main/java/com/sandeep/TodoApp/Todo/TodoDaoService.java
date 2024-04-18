package com.sandeep.TodoApp.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class TodoDaoService {
    private static List<Todo> todoList;
    private static int todoCount = 1;
    static {
        todoList = new ArrayList<>();
        todoList.add(new Todo(todoCount++, "sandeep", "Learn React", LocalDate.now(), false));
        todoList.add(new Todo(todoCount++, "sandeep", "Learn AWS", LocalDate.now(), false));
        todoList.add(new Todo(todoCount++, "sandeep", "Learn Spring Boot", LocalDate.now(), false));
        todoList.add(new Todo(todoCount++, "sandeep", "Learn Sql", LocalDate.now(), true));
    }

    public List<Todo> findByUserName(String userName) {
        Predicate<? super Todo> predicate = (user) -> user.getUsername().equalsIgnoreCase(userName);
        return todoList.stream().filter(predicate).toList();
    }

    public Todo addTodo(String userName, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(todoCount++, userName, description, targetDate, done);
        todoList.add(todo);
        return todo;
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = (todo) -> todo.getId() == id;
        return todoList.stream().filter(predicate).findFirst().get();
    }

    public void deleteById(int id) {
        todoList.removeIf((todo) -> todo.getId() == id);
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todoList.add(todo);
    }
}
