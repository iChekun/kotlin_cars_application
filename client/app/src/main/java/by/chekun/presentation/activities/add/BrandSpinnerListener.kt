package by.chekun.presentation.activities.add

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import by.chekun.repository.database.entity.brand.BrandDto


class BrandSpinnerListener(
        private val dataAdapter: ArrayAdapter<BrandDto>,
        private val spinner: Spinner
) : OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // On selecting a spinner item
        val item = parent.getItemAtPosition(position).toString()

        // Showing selected spinner item
        println(parent.selectedItemId)

        Toast.makeText(parent.context, "Selected: $item" + " id=" + parent.selectedItemId, Toast.LENGTH_LONG).show()
    }

    fun configureSpinner() {
        spinner.onItemSelectedListener = this
        spinner.adapter = dataAdapter
        spinner.prompt = "Select brand!"
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}