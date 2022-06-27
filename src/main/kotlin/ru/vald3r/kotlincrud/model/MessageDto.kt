package ru.vald3r.kotlincrud.model

import java.io.Serializable

data class MessageDto(val text: String? = null, val authorId: Long? = null) : Serializable{
}
