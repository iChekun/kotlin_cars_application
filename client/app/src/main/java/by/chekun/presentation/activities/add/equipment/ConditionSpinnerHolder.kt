package by.chekun.presentation.activities.add.equipment

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import by.chekun.repository.database.entity.car.equipment.ConditionDto
import com.androidbuts.multispinnerfilter.KeyPairBoolData
import com.androidbuts.multispinnerfilter.SingleSpinner

class ConditionSpinnerHolder(private val conditionSingleSpinner: SingleSpinner) {


    fun initModelSpinnerHolderWithValues(values: Set<ConditionDto>) {
        initModelSpinner(values)
    }


    private fun initModelSpinner(values: Set<ConditionDto>) {

        val list: MutableList<KeyPairBoolData> = java.util.ArrayList()

        values.forEach { condition ->
            val h = KeyPairBoolData()
            h.id = condition.id
            h.name = condition.value
            h.isSelected = false
            list.add(h)
        }

        conditionSingleSpinner.isColorseparation = true
        conditionSingleSpinner.setItems(list, -1) { items ->
            for (i in items!!.indices) {
                if (items[i].isSelected) {

                }
            }
        }

    }
}