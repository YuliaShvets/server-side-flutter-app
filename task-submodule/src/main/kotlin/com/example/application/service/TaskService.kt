package com.example.application.service

import com.example.application.repository.TaskRepositoryOutPort
import com.example.domain.Task
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class TaskService(
        private val taskRepositoryOutPort: TaskRepositoryOutPort
) : TaskInPort {
    override fun findAll(): Flux<Task> = taskRepositoryOutPort.findAll()

    override fun findById(id: String): Mono<Task> = taskRepositoryOutPort.findById(id)
            .switchIfEmpty(Mono.error(RuntimeException()))

    override fun save(entity: Task): Mono<Task> = taskRepositoryOutPort.save(entity)

    override fun update(entity: Task): Mono<Task> = taskRepositoryOutPort.save(entity)

    override fun delete(id: String): Mono<Unit> = taskRepositoryOutPort.deleteById(id)
}