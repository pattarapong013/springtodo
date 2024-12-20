package it.example.demo.todo.controllers

import it.example.demo.todo.entities.Todo
import it.example.demo.todo.services.TodoService
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/todos")
class TodoController @Autowired constructor(val todoService: TodoService) {
    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        return ResponseEntity(todoService.createTodo(todo), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getTodo(@PathVariable id: Long): Todo {
        return todoService.getTodo(id)
    }

    @GetMapping
    fun getAllTodo(): List<Todo> {
        return todoService.getTodoList()
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todo: Todo): Todo {
        return todoService.updateTodo(id, todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): Todo {
        return todoService.deleteTodo(id)
    }
}
