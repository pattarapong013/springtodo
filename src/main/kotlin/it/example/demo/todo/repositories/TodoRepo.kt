package it.example.demo.todo.repositories

import it.example.demo.todo.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepo : JpaRepository<Todo, Long> {
}