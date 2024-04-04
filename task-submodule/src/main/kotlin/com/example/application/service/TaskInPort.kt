package com.example.application.service

import com.example.domain.Task
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TaskInPort {

    fun findAll(): Flux<Task>

    fun findById(id: String): Mono<Task>

    fun save(entity: Task): Mono<Task>

    fun update(entity: Task): Mono<Task>

    fun delete(id: String) : Mono<Unit>
}