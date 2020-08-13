package by.chekun.presentation.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.chekun.databinding.CarItemBinding
import by.chekun.repository.database.entity.car.view.CarDto


class CarViewHolder(private val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private var car: CarDto? = null
    private var listener: CarItemClickListener<CarDto>? = null
    private val itemDetail = View.OnClickListener { listener!!.openDetail(this.car!!) }

    fun bind(car: CarDto, listener: CarItemClickListener<CarDto>) {
        this.car = car
        this.listener = listener
        setupItem()
    }

    private fun setupItem() {
        binding.car = car
        binding.root.setOnClickListener(itemDetail)
    }
}
