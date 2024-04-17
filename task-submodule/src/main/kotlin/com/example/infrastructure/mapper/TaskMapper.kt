package com.example.infrastructure.mapper

import com.example.domain.Task
import com.example.infrastructure.database.model.TaskEntity


fun TaskEntity.toDomainView() : Task =
        Task(
                id = this.id,
                name = this.name,
                isDone = this.isDone
        )

fun Task.toMongoView() : TaskEntity =
        TaskEntity(
                name = this.name,
                isDone = this.isDone
        )
