package by.chekun.domain

import android.app.Application
import by.chekun.repository.AppRepository
import by.chekun.repository.database.pojo.CarRequest
import retrofit2.Call

class AddCarViewModel(application: Application, private val mRepository: AppRepository) : BaseViewModel(application) {

    fun saveCar(car: CarRequest): Call<CarRequest> {
        return mRepository.saveCar(car)
    }

}