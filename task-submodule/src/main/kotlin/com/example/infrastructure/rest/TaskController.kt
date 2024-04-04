package com.example.infrastructure.rest

import com.example.application.service.TaskInPort
import com.example.domain.Task
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/task")
class TaskController(
        private val taskInPort: TaskInPort
)  {

    @GetMapping
    fun findAll(): Flux<Task> = taskInPort.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): Mono<Task> = taskInPort.findById(id)

    @PostMapping
    fun save(@RequestBody entity: Task): Mono<Task> = taskInPort.save(entity)

    @PutMapping
    fun update(@RequestBody entity: Task): Mono<Task> = taskInPort.update(entity)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String): Mono<Unit> = taskInPort.delete(id)

}
