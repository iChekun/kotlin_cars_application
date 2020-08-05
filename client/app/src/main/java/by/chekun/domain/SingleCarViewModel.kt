package by.chekun.domain

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import by.chekun.presentation.widget.SingleLiveEvent
import by.chekun.repository.AppRepository
import by.chekun.repository.database.entity.Car


class SingleCarViewModel(application: Application, private val mRepository: AppRepository) : BaseViewModel(application) {

    private val liveDataItem = SingleLiveEvent<Car>()

    @SuppressLint("CheckResult")
    fun getItem(id: Long) {
        mRepository.getUser(id).subscribe { list -> liveDataItem.value = list }
    }

    fun getLiveDataItem(): LiveData<Car> {
        return liveDataItem
    }
}