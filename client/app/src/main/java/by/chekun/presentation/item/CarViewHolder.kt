package by.chekun.presentation.item

import android.support.v7.widget.RecyclerView
import android.view.View
import by.chekun.repository.database.entity.Car
import kotlinx.android.synthetic.main.item_car.view.*


class CarViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var car: Car? = null
    private var listener: CarItemClickListener<Car>? = null
    private val itemDetail = View.OnClickListener { listener!!.openDetail(this.car!!) }

    fun bind(car: Car, listener: CarItemClickListener<Car>) {
        this.car = car
        this.listener = listener
        setupItem()
    }

    private fun setupItem() {
        view.txtRvId.text = car?.id.toString()
        view.txtName.text = car?.model
        view.txtSurname.text = car?.price.toString()
        view.txtFathername.text = car?.releaseYear.toString()
        view.txtBrandName.text = car?.brand?.title
        view.setOnClickListener(itemDetail)
    }
}
