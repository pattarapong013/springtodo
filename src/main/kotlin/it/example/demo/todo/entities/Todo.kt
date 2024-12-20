package it.example.demo.todo.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity
@Table(name = "todo")
class Todo (
    @Id
    @GeneratedValue
    val id: Long = 0,

    var  title: String ="",

    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER , cascade = [CascadeType.REMOVE], orphanRemoval = true)//ทำให้ดึงข้อมูลไปพร้อมกันได้
    var todoitem: MutableList<Todoitem> = mutableListOf()
){


    override fun toString(): String {
        return "Todo(id=$id, title=$title, todoItem=$todoitem"
    }
}