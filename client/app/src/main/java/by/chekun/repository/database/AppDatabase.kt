package by.chekun.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import by.chekun.repository.database.dao.CarDao
import by.chekun.repository.database.entity.Car


@Database(entities = [(Car::class)], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

}