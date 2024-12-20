package it.example.demo.todo.services

import it.example.demo.todo.entities.Todo
import it.example.demo.todo.entities.Todoitem

interface TodoItemService {
    fun createTodoItem(todoId: Long, todoItem: Todoitem): Todoitem

    fun updateTodoItem(id: Long, todoItem: Todoitem): Todoitem

    fun deleteTodoItem(id: Long): Todoitem

}
