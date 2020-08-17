package by.chekun.presentation.activities.add.equipment

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import by.chekun.repository.database.entity.car.equipment.ColorDto

class ColorSpinnerHolder(private val context: Context,
                         private val spinner: Spinner) {


    fun initModelSpinnerHolderWithValues(values: Set<ColorDto>) {
        initModelSpinner(context, values)
    }


    private fun initModelSpinner(context: Context, engineTypes: Set<ColorDto>) {

        val newList: MutableList<ColorDto> = ArrayList()
        newList.add(ColorDto(""))

        newList.addAll(engineTypes)

        val finalArray = newList.toTypedArray()
        val adapter = createAdapter(context, finalArray)
        //spinner.onItemSelectedListener = this
        spinner.adapter = adapter
        //TransmissionSpinnerListener(adapter, spinner)
    }


    private fun createAdapter(context: Context, values: Array<ColorDto>): ArrayAdapter<ColorDto> {

        return object : ArrayAdapter<ColorDto>(context, android.R.layout.simple_spinner_dropdown_item, values) {


            override fun getCount(): Int {
                return values.size
            }

            override fun getItem(position: Int): ColorDto {
                return values[position]
            }

            override fun getItemId(position: Int): Long {
                return values[position].id
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val label = super.getView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].color
                return label
            }

            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: ViewGroup): View {
                val label = super.getDropDownView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].color
                return label
            }

        }
    }
}