package by.chekun.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import by.chekun.R
import by.chekun.presentation.base.BaseAdapter

import by.chekun.presentation.item.CarItemClickListener
import by.chekun.presentation.item.CarViewHolder
import by.chekun.repository.database.entity.Car



class CarAdapter(private val context: Context, private val cars: List<Car>, private val listener: CarItemClickListener<Car>) :
        BaseAdapter<CarViewHolder, Car, CarItemClickListener<Car>>(cars as MutableList<Car>, listener) {


    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(LayoutInflater.from(context).inflate(R.layout.item_car, parent, false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(cars[position], listener)
    }
}
