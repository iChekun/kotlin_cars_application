package by.chekun.model

import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
class Mileage {

    @Column(name = "mileage", nullable = false)
    var mileage: Int = 0

    @Column(name = "measurement")
    var measurement: String = "km"//измерение

    constructor()

    constructor(mileage: Int) {
        this.mileage = mileage
    }

    constructor(mileage: Int, measurement: String) {
        this.mileage = mileage
        this.measurement = measurement
    }

}

