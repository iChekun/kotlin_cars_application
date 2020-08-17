package by.chekun.repository.database.entity.car


class MileageDto {

    var mileage: Int = 0

    var measurement: String = "km"//измерение


    fun getMileageString(): String {
        return "$mileage $measurement"
    }
}

