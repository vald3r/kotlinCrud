package ru.vald3r.kotlincrud.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "messages")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator::class, property="id")
open class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "text", nullable = false, length = 5000)
    open var text: String? = null

    @Fetch(FetchMode.JOIN)
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "author_id")
    open var author: Author? = null
}