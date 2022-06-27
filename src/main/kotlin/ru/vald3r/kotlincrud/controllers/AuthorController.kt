package ru.vald3r.kotlincrud.controllers

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.vald3r.kotlincrud.model.Author
import ru.vald3r.kotlincrud.service.AuthorService

@RestController
@RequestMapping("/api/v1/authors")
class AuthorController(val service: AuthorService) {
    private val log = KotlinLogging.logger {
    }

    @GetMapping
    fun index(): List<Author> = service.findAuthors()
}