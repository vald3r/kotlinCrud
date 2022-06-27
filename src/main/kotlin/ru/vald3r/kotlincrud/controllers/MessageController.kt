package ru.vald3r.kotlincrud.controllers;

import mu.KotlinLogging;
import org.springframework.web.bind.annotation.*;
import ru.vald3r.kotlincrud.model.Message;
import ru.vald3r.kotlincrud.model.MessageDto;
import ru.vald3r.kotlincrud.service.AuthorService
import ru.vald3r.kotlincrud.service.MessageService


@RestController
@RequestMapping("/api/v1/messages")
class MessageController(val messageService: MessageService, val authorService: AuthorService ) {
    private val log = KotlinLogging.logger {
    }

    @GetMapping
    fun index(): List<Message> = messageService.findMessages()

    @PostMapping
    fun post(@RequestBody messageDto: MessageDto): Message {
        return messageService.post(toMessage(messageDto))
    }

    @PatchMapping
    fun patch(@RequestBody message: Message): Message {
        return messageService.post(message)
    }

    @DeleteMapping
    fun delete(@RequestBody id: Long) {
        messageService.delete(id)
    }


    fun toMessage(messageDto: MessageDto): Message {
        val message = Message()
        message.text = messageDto.text
        message.author = authorService.findAuthor(messageDto.authorId)
        return message
    }
}
