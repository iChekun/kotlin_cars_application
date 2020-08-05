package by.chekun.repository.database.pojo

import by.chekun.repository.database.entity.Car
import com.google.gson.annotations.SerializedName

class CarResponse {

    @SerializedName("records")
    var records: Array<Car>? = null

}