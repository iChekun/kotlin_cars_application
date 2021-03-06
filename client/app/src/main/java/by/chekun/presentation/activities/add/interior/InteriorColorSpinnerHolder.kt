package by.chekun.presentation.activities.add.interior

import by.chekun.repository.database.entity.car.interior.InteriorColorDto
import by.chekun.multispinner.KeyPairBoolData
import by.chekun.multispinner.SingleSpinner

class InteriorColorSpinnerHolder(private val singleSpinner: SingleSpinner) {


    fun initModelSpinnerHolderWithValues(values: Set<InteriorColorDto>) {
        initModelSpinner(values)
    }


    private fun initModelSpinner(values: Set<InteriorColorDto>) {

        val list: MutableList<KeyPairBoolData> = java.util.ArrayList()

        values.forEach { value ->
            val h = KeyPairBoolData()
            h.id = value.id
            h.name = value.interiorColor
            h.isSelected = false
            list.add(h)
        }

        singleSpinner.isColorseparation = true
        singleSpinner.setItems(list, -1) { items ->
            for (i in items!!.indices) {
                if (items[i].isSelected) {

                }
            }
        }
    }

}