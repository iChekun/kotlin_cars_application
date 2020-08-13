package by.chekun.model.sellerdata

import by.chekun.model.AbstractEntity
import javax.persistence.*


@Entity
@Table(name = "sellers")
class Seller : AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var region: Region

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "phoneNumber", nullable = false)
    lateinit var phoneNumber: String


    constructor()


    constructor(id: Long, region: Region, name: String, phoneNumber: String) : super(id) {
        this.region = region
        this.name = name
        this.phoneNumber = phoneNumber
    }

}

