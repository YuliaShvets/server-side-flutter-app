package com.example.application.repository

import com.example.domain.Task
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TaskRepositoryOutPort {

    fun findAll(): Flux<Task>

    fun findById(id: String): Mono<Task>

    fun save(entity : Task): Mono<Task>

    fun update(entity: Task): Mono<Task>

    fun deleteById(id : String): Mono<Unit>
}