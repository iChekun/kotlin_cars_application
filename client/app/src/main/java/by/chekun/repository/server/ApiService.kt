package by.chekun.repository.server

import by.chekun.repository.database.entity.Car
import by.chekun.repository.database.entity.brand.BrandResponse
import by.chekun.repository.database.entity.car.CarResponse
import by.chekun.repository.database.pojo.CarRequest
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    //    @GET("/cars")
//    fun getCars(): Single<Response<Array<Car>>>
    @GET("/cars")
    fun getCars(): Single<Response<CarResponse>>

    @GET("/cars/{id}")
    fun getCarById(@Path("id") id: Long): Single<Car>

    @POST("/cars")
    fun saveCar(@Body carRequest: CarRequest): Call<CarRequest>

//    @GET("/brands")
//    fun getBrands(): Single<Response<Array<BrandDto>>>


//    @GET("/brands")
//    fun getBrands(): Single<BrandResponse>

    @GET("/brands")
    fun getBrands(): Call<BrandResponse>

}