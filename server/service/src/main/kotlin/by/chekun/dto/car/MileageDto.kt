package by.chekun.dto.car


class MileageDto {

    //@NotNull(message = "Mileage must be set")
    var mileage: Int = 0

    var measurement: String = "km"//измерение

    constructor() {
    }

    constructor(mileage: Int) {
        this.mileage = mileage
    }

    constructor(mileage: Int, measurement: String) {
        this.mileage = mileage
        this.measurement = measurement
    }
}

