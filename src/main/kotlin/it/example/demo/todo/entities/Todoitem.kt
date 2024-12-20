package it.example.demo.todo.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "to_item")
class Todoitem (
    @Id
    @GeneratedValue
    val id:Long = 0,
    var content:String = "",
    var complete:Boolean =false,
    @ManyToOne
    @JoinColumn(name = "todo_id")
    var todo: Todo? = null
){
    override fun toString(): String {
        return "TodoItem(id=$id, content=$content,complete=$complete,todo=$todo"
    }
}