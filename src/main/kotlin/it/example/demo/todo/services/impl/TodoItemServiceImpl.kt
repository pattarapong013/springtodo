package it.example.demo.todo.services.impl

import it.example.demo.todo.entities.Todoitem
import it.example.demo.todo.exceptions.NotFoundException
import it.example.demo.todo.repositories.TodoItemRepo
import it.example.demo.todo.repositories.TodoRepo
import it.example.demo.todo.services.TodoItemService
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.Service

@Service
class TodoItemServiceImpl @Autowired constructor(
    val todoRepo: TodoRepo,
    val todoItemRepo: TodoItemRepo
) : TodoItemService {

    override fun createTodoItem(todoId: Long, todoItem: Todoitem): Todoitem {
        val todo = todoRepo.findById(todoId).orElseThrow {
            NotFoundException("No Todo with id $todoId")
        }
        todoItem.todo = todo
        return todoItemRepo.saveAndFlush(todoItem)
    }

    override fun updateTodoItem(id: Long, todoItem: Todoitem): Todoitem {
        val existingItem = todoItemRepo.findById(id).orElseThrow {
            NotFoundException("No TodoItem with id $id")
        }
        existingItem.content = todoItem.content
        existingItem.complete = todoItem.complete
        return todoItemRepo.saveAndFlush(existingItem)
    }

    override fun deleteTodoItem(id: Long): Todoitem {
        val existingItem = todoItemRepo.findById(id).orElseThrow {
            NotFoundException("No TodoItem with id $id")
        }
        todoItemRepo.delete(existingItem)
        return existingItem
    }
}

