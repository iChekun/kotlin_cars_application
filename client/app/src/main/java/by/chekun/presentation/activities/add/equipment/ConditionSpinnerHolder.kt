package by.chekun.presentation.activities.add.equipment

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import by.chekun.repository.database.entity.car.equipment.ConditionDto

class ConditionSpinnerHolder(private val context: Context,
private val spinner: Spinner) {


    fun initModelSpinnerHolderWithValues(conditions: Set<ConditionDto>) {
        initModelSpinner(context, conditions)
    }


    private fun initModelSpinner(context: Context, models: Set<ConditionDto>) {

        val newList: MutableList<ConditionDto> = ArrayList()
        newList.add(ConditionDto(""))

        newList.addAll(models)

        val conditionsArray = newList.toTypedArray()
        val adapter = createModelAdapter(context, conditionsArray)
        spinner.adapter = adapter
    }


    private fun createModelAdapter(context: Context, values: Array<ConditionDto>): ArrayAdapter<ConditionDto> {

        return object : ArrayAdapter<ConditionDto>(context, android.R.layout.simple_spinner_dropdown_item, values) {


            override fun getCount(): Int {
                return values.size
            }

            override fun getItem(position: Int): ConditionDto {
                return values[position]
            }

            override fun getItemId(position: Int): Long {
                return values[position].id
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val label = super.getView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].value
                return label
            }

            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: ViewGroup): View {
                val label = super.getDropDownView(position, convertView, parent) as TextView
                label.setTextColor(Color.BLACK)
                label.text = values[position].value
                return label
            }

        }
    }
}