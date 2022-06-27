package ru.vald3r.kotlincrud.service

import org.springframework.stereotype.Service
import ru.vald3r.kotlincrud.model.Author
import ru.vald3r.kotlincrud.repo.AuthorRepository

@Service
class AuthorService(val db: AuthorRepository){

    fun findAuthors(): List<Author> = db.findAll().toList()

    fun post(message: Author): Author {
        return db.save(message)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }

    fun findAuthor(authorId: Long?): Author? {
        authorId?.let { return db.findById(it).orElseThrow() }
        return null
    }
}
