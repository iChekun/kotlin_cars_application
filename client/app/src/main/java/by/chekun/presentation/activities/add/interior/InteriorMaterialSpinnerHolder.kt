package by.chekun.presentation.activities.add.interior

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import by.chekun.repository.database.entity.car.interior.InteriorMaterialDto

class InteriorMaterialSpinnerHolder(private val context: Context,
                                    private val spinner: Spinner) {


    fun initModelSpinnerHolderWithValues(values: Set<InteriorMaterialDto>) {
        initModelSpinner(context, values)
    }


    private fun initModelSpinner(context: Context, engineTypes: Set<InteriorMaterialDto>) {

        val newList: MutableList<InteriorMaterialDto> = ArrayList()
        newList.add(InteriorMaterialDto(""))

        newList.addAll(engineTypes)

        val finalArray = newList.toTypedArray()
        val adapter = createAdapter(context, finalArray)
        //spinner.onItemSelectedListener = this
        spinner.adapter = adapter
        //TransmissionSpinnerListener(adapter, spinner)
    }


    private fun createAdapter(context: Context, values: Array<InteriorMaterialDto>): ArrayAdapter<InteriorMaterialDto> {

        return object : ArrayAdapter<InteriorMaterialDto>(context, android.R.layout.simple_spinner_dropdown_item, values) {


            override fun getCount(): Int {
                return values.size
            }

            override fun getItem(position: Int): InteriorMaterialDto {
                return values[position]
            }

            override fun getItemId(position: Int): Long {
                return values[position].id
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val label = super.getView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].interiorMaterial
                return label
            }

            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: ViewGroup): View {
                val label = super.getDropDownView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].interiorMaterial
                return label
            }

        }
    }
}