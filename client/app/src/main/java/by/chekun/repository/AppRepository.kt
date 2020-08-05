package by.chekun.repository

import by.chekun.repository.database.AppDatabase
import by.chekun.repository.database.entity.Car
import by.chekun.repository.server.ServerCommunicator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {
    /*
     fun getAll(): Single<List<CarEntity>?> {
        return serverCommunicator.getAllUsers().flatMap { list ->
            Single.just(
                    list.body()?.toList()
            )
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getUser(id: Long): Single<CarEntity> {
        return serverCommunicator.getUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
     */
    fun getAll(): Single<List<Car>>? {
        return serverCommunicator.getAllUsers()
                .flatMap { list ->
                    mainDatabase.carDao().insertList(list.body())
                    Single.just(mainDatabase.carDao().getAll())
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getUser(id: Long): Single<Car> {
        return serverCommunicator.getUser(id)
                .map {
                    val user = mainDatabase.carDao().getById(id)
                    user
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }
}