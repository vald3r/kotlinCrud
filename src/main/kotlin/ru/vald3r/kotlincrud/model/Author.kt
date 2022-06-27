package ru.vald3r.kotlincrud.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "authors")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator::class, property="id")
open class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 2048)
    open var name: String? = null

    @Fetch(FetchMode.JOIN)
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    @OneToMany(mappedBy = "author", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var messages: MutableSet<Message> = mutableSetOf()
}