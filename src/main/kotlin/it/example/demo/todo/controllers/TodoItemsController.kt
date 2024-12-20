package it.example.demo.todo.controllers
import  it.example.demo.todo.entities.Todoitem
import it.example.demo.todo.services.TodoItemService
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/todos")
class TodoItemsController @Autowired constructor(val todoItemService: TodoItemService) {
    @PostMapping("/{todoId}/items")
    fun createTodoItem(@PathVariable(name = "todoId") todoId: Long,
                       @RequestBody todoItem: Todoitem): ResponseEntity<Todoitem> {
        return ResponseEntity(todoItemService.createTodoItem(todoId, todoItem), HttpStatus.CREATED)
    }

    @PutMapping("/items/{id}")
    fun updateTodoItem(@PathVariable id: Long, @RequestBody todoItem: Todoitem): Todoitem {
        return todoItemService.updateTodoItem(id, todoItem)
    }

    @DeleteMapping("/items/{id}")
    fun deleteTodoItem(@PathVariable id: Long): Todoitem {
        return todoItemService.deleteTodoItem(id)
    }
}


