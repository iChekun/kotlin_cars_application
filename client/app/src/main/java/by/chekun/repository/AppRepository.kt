package by.chekun.repository

import by.chekun.repository.database.AppDatabase
import by.chekun.repository.database.entity.Car
import by.chekun.repository.database.entity.brand.BrandResponse
import by.chekun.repository.database.entity.car.view.CarDto
import by.chekun.repository.database.pojo.CarRequest
import by.chekun.repository.server.ServerCommunicator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call


class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {

    fun getAllCars(): Single<List<CarDto>?> {
        return serverCommunicator.getAllCars()
                .flatMap { list ->
                    //mainDatabase.carDao().insertList(list.body().cars)
                    Single.just(list.body()?.cars)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getCar(id: Long): Single<Car> {
        return serverCommunicator.getCar(id)
                .map {
                    val user = mainDatabase.carDao().getById(id)
                    user
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

    fun saveCar(car: CarRequest): Call<CarRequest> {
        return serverCommunicator.saveCar(car)
    }

    fun getAllBrands(): Call<BrandResponse>? {
        return serverCommunicator.getBrands()
    }


}