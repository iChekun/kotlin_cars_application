package by.chekun.presentation.activities.add.chassis

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import by.chekun.repository.database.entity.car.chassis.TransmissionTypeDto

class TransmissionSpinnerHolder(private val context: Context,
                                private val spinner: Spinner) {


    fun initModelSpinnerHolderWithValues(values: Set<TransmissionTypeDto>) {
        initModelSpinner(context, values)
    }


    private fun initModelSpinner(context: Context, engineTypes: Set<TransmissionTypeDto>) {

        val newList: MutableList<TransmissionTypeDto> = ArrayList()
        newList.add(TransmissionTypeDto(""))

        newList.addAll(engineTypes)

        val finalArray = newList.toTypedArray()
        val adapter = createAdapter(context, finalArray)
        //spinner.onItemSelectedListener = this
        spinner.adapter = adapter
        spinner.adapter = adapter
    }


    private fun createAdapter(context: Context, values: Array<TransmissionTypeDto>): ArrayAdapter<TransmissionTypeDto> {

        return object : ArrayAdapter<TransmissionTypeDto>(context, android.R.layout.simple_spinner_dropdown_item, values) {


            override fun getCount(): Int {
                return values.size
            }

            override fun getItem(position: Int): TransmissionTypeDto {
                return values[position]
            }

            override fun getItemId(position: Int): Long {
                return values[position].id
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val label = super.getView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].transmissionType
                return label
            }

            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: ViewGroup): View {
                val label = super.getDropDownView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].transmissionType
                return label
            }

        }
    }
}