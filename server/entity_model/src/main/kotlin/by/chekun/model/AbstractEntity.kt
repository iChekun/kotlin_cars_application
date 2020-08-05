package by.chekun.model

import java.io.Serializable
import javax.persistence.*


@MappedSuperclass
open class AbstractEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    var id: Long = 0

) : Serializable