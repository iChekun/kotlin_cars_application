package by.chekun.dto.car

import javax.validation.constraints.NotNull


class MileageDto {

    @NotNull(message = "Brand must be selected")
    var mileage: Double = 0.0

    var measurement: String = "km"//измерение

}

