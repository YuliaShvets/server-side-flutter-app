package com.example.infrastructure.database.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("task")
data class TaskEntity(
        val name : String,
        val isDone : Boolean
) {
    @Id
    lateinit var id: String
}