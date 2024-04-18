package com.sandeep.TodoApp.Todo.repository;
import com.sandeep.TodoApp.Todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer>{
    List<Todo> findByUsername(String username);
}
