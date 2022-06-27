package ru.vald3r.kotlincrud.repo;

import org.springframework.data.jpa.repository.JpaRepository
import ru.vald3r.kotlincrud.model.Author

interface AuthorRepository : JpaRepository<Author, Long> {
}