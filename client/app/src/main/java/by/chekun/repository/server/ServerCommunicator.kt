package by.chekun.repository.server

import android.util.Log
import by.chekun.repository.database.entity.Car
import by.chekun.repository.database.entity.brand.BrandResponse
import by.chekun.repository.database.entity.car.CarResponse
import by.chekun.repository.database.pojo.CarRequest
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.TimeUnit


class ServerCommunicator(private val mService: ApiService) {

    companion object {
        private const val DEFAULT_TIMEOUT = 10
        private const val DEFAULT_RETRY_ATTEMPTS = 4L
    }

    fun getAllCars(): Single<Response<CarResponse>> {
        return mService.getCars()
                .compose(singleTransformer())
                .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message.toString()) }
    }

    fun getCar(id: Long): Single<Car> {
        return mService.getCarById(id).compose(singleTransformer())
    }

    fun saveCar(car: CarRequest): Call<CarRequest> {
        return mService.saveCar(car)
    }


    fun getBrands(): Call<BrandResponse>? {
        return mService.getBrands()
    }


    private fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retry(DEFAULT_RETRY_ATTEMPTS)
    }

    private fun <T> observableTransformer(): ObservableTransformer<T, T> = ObservableTransformer {
        it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retry(DEFAULT_RETRY_ATTEMPTS)
    }
}


