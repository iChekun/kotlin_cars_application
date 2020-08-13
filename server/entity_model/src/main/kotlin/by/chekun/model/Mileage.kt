package by.chekun.model

import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
class Mileage(mileage: Double, measurement: String) {

    @Column(name = "mileage", nullable = false)
    var mileage: Double = 0.0

    @Column(name = "measurement")
    var measurement: String = "km"//измерение


}

