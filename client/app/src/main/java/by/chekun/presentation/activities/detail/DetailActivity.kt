package by.chekun.presentation.activities.detail

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import by.chekun.R
import by.chekun.di.component.ViewModelComponent
import by.chekun.domain.SingleCarViewModel
import by.chekun.presentation.base.BaseActivity
import by.chekun.repository.database.entity.Car

import kotlinx.android.synthetic.main.activity_detail.*


import java.util.*
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    var viewModel: SingleCarViewModel? = null
        @Inject set

    private var carId: Long = 0

    companion object {
        @JvmStatic
        fun newInstance(context: Context, id: Long): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(context.getString(R.string.EXTRAS_ID), id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        initViewModel()
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    private fun initViewModel() {
        carId = intent.getLongExtra(getString(R.string.EXTRAS_ID), 0)
        viewModel?.getItem(carId)
        viewModel?.getLiveDataItem()?.observe(this, Observer { it?.let { initTextViews(it) } })
    }

    private fun initTextViews(car: Car) {
        txtDetailId.text = car.id.toString()
        txtDetailName.text = car.model
        txtDetailSurname.text = car.price.toString()
        txtDetailFathername.text = car.releaseYear.toString()
        txtDetailBrandName.text = car.brand.title
        initActionBar(car.model)
    }

    private fun initActionBar(title: String) {
        Objects.requireNonNull(supportActionBar)?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
