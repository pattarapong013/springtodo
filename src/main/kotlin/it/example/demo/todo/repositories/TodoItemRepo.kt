package it.example.demo.todo.repositories

import it.example.demo.todo.entities.Todoitem
import org.springframework.data.jpa.repository.JpaRepository

interface TodoItemRepo : JpaRepository<Todoitem, Long>
