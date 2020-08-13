package by.chekun.model.chassis

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "transmission_types")
class TransmissionType : AbstractEntity {

    @Column(name = "transmission_type", nullable = false, unique = true)
    lateinit var transmissionType: String


    constructor()

    constructor(id: Long, transmissionType: String) : super(id) {
        this.transmissionType = transmissionType
    }


}

