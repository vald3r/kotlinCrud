package ru.vald3r.kotlincrud.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.vald3r.kotlincrud.model.Message

interface MessageRepository : JpaRepository<Message, Long>
