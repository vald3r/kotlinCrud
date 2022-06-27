package ru.vald3r.kotlincrud.service

import org.springframework.stereotype.Service
import ru.vald3r.kotlincrud.model.Message
import ru.vald3r.kotlincrud.repo.MessageRepository


@Service
class MessageService(val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun post(message: Message): Message {
        return db.save(message)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }



}