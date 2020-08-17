package by.chekun.presentation.activities.add

import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import by.chekun.R
import by.chekun.di.component.ViewModelComponent
import by.chekun.domain.AddCarViewModel
import by.chekun.presentation.activities.main.MainActivity
import by.chekun.presentation.base.BaseActivity
import by.chekun.repository.database.entity.brand.ReleaseYearDto
import by.chekun.repository.database.entity.car.CarRequestDto
import by.chekun.repository.database.entity.car.MileageDto
import by.chekun.repository.database.entity.car.view.CarDto
import by.chekun.utils.*
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch
import com.androidbuts.multispinnerfilter.SingleSpinner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.inject.Inject
import kotlin.collections.HashMap


class AddCarActivity : BaseActivity() {

    var viewModel: AddCarViewModel? = null
        @Inject set

    private var saveButton: Button? = null
    private val addActivitySpinners: MutableMap<String, Spinner> = HashMap()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)


        saveButton = findViewById(R.id.car_save_button)
        //saveButton?.isEnabled = false

        createSpinnersMap()
        SpinnerHolder(viewModel, addActivitySpinners).initSpinners(this)
        initDigitsFilter()
    }

    private fun initDigitsFilter() {
        val priceEditText = findViewById<EditText>(R.id.txt_price_value)
        priceEditText.filters = arrayOf<InputFilter>(DecimalDigitsInputFilter(10, 2))
    }


    private fun createSpinnersMap() {
        val brandSpinner: Spinner = findViewById(R.id.brand_spinner)
        val modelSpinner: Spinner = findViewById(R.id.model_spinner)
        val releaseYearSpinner: Spinner = findViewById(R.id.release_year_spinner)
        val generationSpinner: Spinner = findViewById(R.id.generation_spinner)
        val bodyTypeSpinner: Spinner = findViewById(R.id.body_type_spinner)


        val conditionSpinner: SingleSpinner = findViewById(R.id.condition_spinner)

        val engineSpinner: SingleSpinner = findViewById(R.id.engine_spinner)

        val transmissionSpinner: SingleSpinner = findViewById(R.id.transmission_type_spinner)
        val wheelDriveTypeSpinner: SingleSpinner = findViewById(R.id.wheel_drive_spinner)
        val colorSpinner: SingleSpinner = findViewById(R.id.color_spinner)
        val interiorColorSpinner: SingleSpinner = findViewById(R.id.interior_color_spinner)
        val interiorMaterialSpinner: SingleSpinner = findViewById(R.id.interior_material_spinner)

        val safetiesMultipleSpinner: MultiSpinnerSearch = findViewById(R.id.searchMultiSpinnerUnlimited)


        addActivitySpinners[BRAND_SPINNER_KEY] = brandSpinner
        addActivitySpinners[MODEL_SPINNER_KEY] = modelSpinner
        addActivitySpinners[RELEASE_YEAR_SPINNER_KEY] = releaseYearSpinner
        addActivitySpinners[BODY_TYPE_SPINNER_KEY] = bodyTypeSpinner
        addActivitySpinners[GENERATION_SPINNER_KEY] = generationSpinner

        addActivitySpinners[CONDITION_SPINNER_KEY] = conditionSpinner


        addActivitySpinners[ENGINE_TYPE_SPINNER_KEY] = engineSpinner

        addActivitySpinners[TRANSMISSION_TYPE_SPINNER_KEY] = transmissionSpinner
        addActivitySpinners[WHEEL_DRIVE_TYPE_SPINNER_KEY] = wheelDriveTypeSpinner
        addActivitySpinners[COLOR_TYPE_SPINNER_KEY] = colorSpinner
        addActivitySpinners[INTERIOR_COLOR_TYPE_SPINNER_KEY] = interiorColorSpinner
        addActivitySpinners[INTERIOR_MATERIAL_TYPE_SPINNER_KEY] = interiorMaterialSpinner

        addActivitySpinners[SAFETIES_MULTIPLE_SPINNER_KEY] = safetiesMultipleSpinner
    }


    fun clickSaveCar(view: View?) {

        val brandId: Long = addActivitySpinners[BRAND_SPINNER_KEY]!!.selectedItemId
        val modelId: Long = addActivitySpinners[MODEL_SPINNER_KEY]!!.selectedItemId
        val generationId: Long = addActivitySpinners[GENERATION_SPINNER_KEY]!!.selectedItemId
        val bodyTypeId: Long = addActivitySpinners[BODY_TYPE_SPINNER_KEY]!!.selectedItemId
        val transmissionTypeId: Long = addActivitySpinners[TRANSMISSION_TYPE_SPINNER_KEY]!!.selectedItemId
        val engineTypeId: Long = addActivitySpinners[ENGINE_TYPE_SPINNER_KEY]!!.selectedItemId
        val wheelDriveTypeId: Long = addActivitySpinners[WHEEL_DRIVE_TYPE_SPINNER_KEY]!!.selectedItemId
        val colorId: Long = addActivitySpinners[COLOR_TYPE_SPINNER_KEY]!!.selectedItemId
        val conditionId: Long = addActivitySpinners[CONDITION_SPINNER_KEY]!!.selectedItemId
        val interiorColorId: Long = addActivitySpinners[INTERIOR_COLOR_TYPE_SPINNER_KEY]!!.selectedItemId
        val interiorMaterialId: Long = addActivitySpinners[INTERIOR_MATERIAL_TYPE_SPINNER_KEY]!!.selectedItemId
        val releaseYear: Int = (addActivitySpinners[RELEASE_YEAR_SPINNER_KEY]!!.selectedItem as ReleaseYearDto).releaseYear


        val priceEditText = findViewById<EditText>(R.id.txt_price_value)
        val price: Double = priceEditText.text.toString().toDouble()

        val mileageEditText = findViewById<EditText>(R.id.txt_mileage)
        val mileageDistance: Int = mileageEditText.text.toString().toInt()
        val mileage = MileageDto()
        mileage.mileage = mileageDistance

        val carRequestDto = CarRequestDto()
        carRequestDto.brandId = brandId
        carRequestDto.modelId = modelId
        carRequestDto.generationId = generationId
        carRequestDto.bodyTypeId = bodyTypeId
        carRequestDto.transmissionTypeId = transmissionTypeId
        carRequestDto.engineTypeId = engineTypeId

        val engineCapacityEditText = findViewById<EditText>(R.id.txt_engine_capacity)
        carRequestDto.engineCapacity = engineCapacityEditText.text.toString().toDouble()

        carRequestDto.wheelDriveTypeId = wheelDriveTypeId
        carRequestDto.colorId = colorId
        carRequestDto.conditionId = conditionId
        carRequestDto.interiorColorId = interiorColorId
        carRequestDto.interiorMaterialId = interiorMaterialId
        carRequestDto.releaseYear = releaseYear
        carRequestDto.price = price
        carRequestDto.mileage = mileage

        val descriptionEditText = findViewById<EditText>(R.id.txt_description_value)
        carRequestDto.description = descriptionEditText.text.toString()


        //val car = CarRequest(model, generation, mileage, bodyType, transmissionType, fuelType, wheelDriveType, engineCapacity, releaseYear, price, description, 1)

        //println(car.toString())

//        viewModel?.saveCar(carRequestDto)?.enqueue(object : Callback<CarDto> {
//
//            override fun onResponse(call: Call<CarDto>?, response: Response<CarDto>) {
//
//                if (response.isSuccessful) {
//
//                    showToast("CarDto added")
//                    showMainActivity()
//                } else {
//                    showToast("Can`t create car! Fill fields according with pattern.")
//                }
//
//            }
//
//            override fun onFailure(call: Call<CarDto>?, t: Throwable?) {
//                showToast("Mistake throwable!")
//            }
//        })


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_new_car, menu)
        // Action View
        //MenuItem searchItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Configure the search info and add any event listeners
        //return super.onCreateOptionsMenu(menu);
        return true
    }


}


class DecimalDigitsInputFilter(digitsBeforeZero: Int, digitsAfterZero: Int) : InputFilter {

    private val mPattern: Pattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?")

    override fun filter(source: CharSequence,
                        start: Int,
                        end: Int,
                        dest: Spanned,
                        dstart: Int,
                        dend: Int): CharSequence? {
        val matcher: Matcher = mPattern.matcher(dest)
        return if (!matcher.matches()) "" else null
    }

}