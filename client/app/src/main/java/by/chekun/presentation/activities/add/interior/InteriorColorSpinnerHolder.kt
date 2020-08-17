package by.chekun.presentation.activities.add.interior

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import by.chekun.repository.database.entity.car.interior.InteriorColorDto

class InteriorColorSpinnerHolder(private val context: Context,
                                 private val spinner: Spinner) {


    fun initModelSpinnerHolderWithValues(values: Set<InteriorColorDto>) {
        initModelSpinner(context, values)
    }


    private fun initModelSpinner(context: Context, engineTypes: Set<InteriorColorDto>) {

        val newList: MutableList<InteriorColorDto> = ArrayList()
        newList.add(InteriorColorDto(""))

        newList.addAll(engineTypes)

        val finalArray = newList.toTypedArray()
        val adapter = createAdapter(context, finalArray)
        //spinner.onItemSelectedListener = this
        spinner.adapter = adapter
        //TransmissionSpinnerListener(adapter, spinner)
    }


    private fun createAdapter(context: Context, values: Array<InteriorColorDto>): ArrayAdapter<InteriorColorDto> {

        return object : ArrayAdapter<InteriorColorDto>(context, android.R.layout.simple_spinner_dropdown_item, values) {


            override fun getCount(): Int {
                return values.size
            }

            override fun getItem(position: Int): InteriorColorDto {
                return values[position]
            }

            override fun getItemId(position: Int): Long {
                return values[position].id
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val label = super.getView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].interiorColor
                return label
            }

            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: ViewGroup): View {
                val label = super.getDropDownView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].interiorColor
                return label
            }

        }
    }
}