package by.chekun.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import by.chekun.databinding.CarItemBinding
import by.chekun.presentation.base.BaseAdapter
import by.chekun.presentation.item.CarItemClickListener
import by.chekun.presentation.item.CarViewHolder
import by.chekun.repository.database.entity.car.view.CarDto


class CarAdapter(private val context: Context, private val cars: List<CarDto>, private val listener: CarItemClickListener<CarDto>) :
        BaseAdapter<CarViewHolder, CarDto, CarItemClickListener<CarDto>>(cars as MutableList<CarDto>, listener) {


    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val binding: CarItemBinding = CarItemBinding.inflate(inflater, parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(cars[position], listener)
    }
}
