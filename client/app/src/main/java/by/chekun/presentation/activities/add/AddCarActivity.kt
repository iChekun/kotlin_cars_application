package by.chekun.presentation.activities.add

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import by.chekun.R
import by.chekun.di.component.ViewModelComponent
import by.chekun.domain.AddCarViewModel
import by.chekun.presentation.activities.main.MainActivity
import by.chekun.presentation.base.BaseActivity
import by.chekun.repository.database.pojo.CarRequest
import kotlinx.android.synthetic.main.activity_add_car.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject


class AddCarActivity : BaseActivity() {

    var viewModel: AddCarViewModel? = null
        @Inject set

    var et_model: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)


        et_model = findViewById(R.id.model_text_field) as EditText

        addBrandSpinner()
    }

    private fun addBrandSpinner() {
        val spinner: Spinner = findViewById(R.id.brand_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.brand_ids,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }


    fun clickSaveCar(view: View?) {

        val model: String = et_model?.text.toString()
        val generation: String = R.id.generation_text_field.toString()
        val mileage: Double = R.id.mileage_text_field.toDouble()
        val bodyType: String = body_type_text_field.text.toString()
        val transmissionType: String = transmission_type_text_field.text.toString()
        val fuelType: String = fuel_type_text_field.text.toString()
        val wheelDriveType: String = wheel_drive_type_text_field.text.toString()
        val engineCapacity: Double = R.id.engine_capacity_text_field.toDouble()
        val releaseYear: Int = R.id.release_year_text_field.toInt()
        val price: Double = R.id.price_text_fild.toDouble()
        val description: String = ""
        val mySpinner = findViewById<View>(R.id.brand_spinner) as Spinner
        val brandId: String = mySpinner.selectedItem.toString()

        println(brandId)


        val car = CarRequest(model, generation, mileage, bodyType, transmissionType, fuelType, wheelDriveType, engineCapacity, releaseYear, price, description, 1)

        println(car.toString())

        viewModel?.saveCar(car)?.enqueue(object : Callback<CarRequest> {

            override fun onResponse(call: Call<CarRequest>?, response: Response<CarRequest>) {

                if (response.isSuccessful) {
                    Log.i(ContentValues.TAG, "post submitted to API." + response.body().toString())

                    showToast("Car added")
                    showMainActivity()
                } else {

                    showToast("Can`t create car! Fill fields according with pattern.")
                    Log.i(ContentValues.TAG, "Mistake onResponse! ." + response.body().toString())
                }

            }

            override fun onFailure(call: Call<CarRequest>?, t: Throwable?) {

                showToast("Mistake throwable!")
                Log.i(ContentValues.TAG, "Mistake throwable! ." + t.toString())
            }
        })


    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun showMainActivity() {
        startActivity(MainActivity.newInstance(this))
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

}