package by.chekun.model.chassis

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "whell_drive_types")
class WheelDriveType : AbstractEntity {

    @Column(name = "Wheel_drive_type", nullable = false, unique = true)
    lateinit var wheelDriveType: String


    constructor()

    constructor(id: Long, wheelDriveType: String) : super(id) {
        this.wheelDriveType = wheelDriveType
    }


}

