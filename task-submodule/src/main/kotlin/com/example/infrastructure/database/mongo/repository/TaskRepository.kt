package com.example.infrastructure.database.mongo.repository

import com.example.application.repository.TaskRepositoryOutPort
import com.example.domain.Task
import com.example.infrastructure.database.model.TaskEntity
import com.example.infrastructure.mapper.toDomainView
import com.example.infrastructure.mapper.toMongoView
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class TaskRepository(private val reactiveMongoTemplate: ReactiveMongoTemplate) : TaskRepositoryOutPort {

    override fun findAll(): Flux<Task> {
        return reactiveMongoTemplate.findAll(TaskEntity::class.java).map {
            it.toDomainView()
        }
    }

    override fun findById(id: String): Mono<Task> {
        val query = Query()
                .addCriteria(Criteria.where("_id").`is`(id))
        return reactiveMongoTemplate.findOne(query, TaskEntity::class.java)
                .map { it.toDomainView() }
    }

    override fun save(entity: Task): Mono<Task> {
        return reactiveMongoTemplate.save(entity.toMongoView())
                .map { it.toDomainView() }
    }

    override fun update(entity: Task): Mono<Task> {
        return reactiveMongoTemplate.save(entity.toMongoView())
                .map { it.toDomainView() }
    }

    override fun deleteById(id: String): Mono<Unit> {
        val query = Query()
                .addCriteria(Criteria.where("_id").`is`(id))
        return reactiveMongoTemplate.remove(query, TaskEntity::class.java).map {  }
    }

}