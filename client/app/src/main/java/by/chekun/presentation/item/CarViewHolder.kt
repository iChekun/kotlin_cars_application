package by.chekun.presentation.item

import android.support.v7.widget.RecyclerView
import android.view.View
import by.chekun.databinding.CarItemBinding
import by.chekun.repository.database.entity.Car


class CarViewHolder(private val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private var car: Car? = null
    private var listener: CarItemClickListener<Car>? = null
    private val itemDetail = View.OnClickListener { listener!!.openDetail(this.car!!) }

    fun bind(car: Car, listener: CarItemClickListener<Car>) {
        this.car = car
        this.listener = listener
        setupItem()
    }

    private fun setupItem() {
        binding.car = car
        binding.root.setOnClickListener(itemDetail)
    }
}
