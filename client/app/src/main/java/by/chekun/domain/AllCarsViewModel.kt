package by.chekun.domain

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import by.chekun.presentation.widget.SingleLiveEvent
import by.chekun.repository.AppRepository
import by.chekun.repository.database.entity.Car

class AllCarsViewModel(application: Application, private val mRepository: AppRepository) : BaseViewModel(application) {
    private val liveDataItems = SingleLiveEvent<List<Car>>()

    @SuppressLint("CheckResult")
    fun getAllItems() {
        mRepository.getAll()?.subscribe { list -> liveDataItems.value = list}
    }

    fun getLiveDataItems(): LiveData<List<Car>> {
        return liveDataItems
    }
}