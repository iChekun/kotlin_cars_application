package by.chekun.repository.server

import by.chekun.repository.database.entity.Car
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/cars")
    fun getCars(): Single<Response<Array<Car>>>

    @GET("/cars/{id}")
    fun getCarById(@Path("id") id: Long): Single<Car>
}