package by.chekun.di.module

import android.app.Application
import by.chekun.App
import by.chekun.di.scope.ViewModelScope
import by.chekun.domain.AllCarsViewModel
import by.chekun.domain.SingleCarViewModel
import by.chekun.repository.AppRepository

import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesAllUserViewModel(repository: AppRepository): AllCarsViewModel {
        return AllCarsViewModel(app, repository)
    }

    @ViewModelScope
    @Provides
    internal fun providesSingleUserViewModel(repository: AppRepository): SingleCarViewModel {
        return SingleCarViewModel(app, repository)
    }
}