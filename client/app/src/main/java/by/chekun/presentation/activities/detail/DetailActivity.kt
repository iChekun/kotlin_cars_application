package by.chekun.presentation.activities.detail

import androidx.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import by.chekun.R
import by.chekun.databinding.CarDetailBinding
import by.chekun.di.component.ViewModelComponent
import by.chekun.domain.SingleCarViewModel
import by.chekun.presentation.base.BaseActivity
import by.chekun.repository.database.entity.car.view.CarDto


import java.util.*
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    var viewModel: SingleCarViewModel? = null
        @Inject set

    private lateinit var binding: CarDetailBinding
    private var carId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.title = "Подробный просмотр"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        initViewModel()
    }

    private fun initViewModel() {
        carId = intent.getLongExtra(getString(R.string.EXTRAS_ID), 0)
        viewModel?.getItem(carId)
        viewModel?.getLiveDataItem()?.observe(this, Observer { it?.let { initDataBinding(it) } })
    }

    private fun initDataBinding(car: CarDto) {
        binding.car = car
        initActionBar("${car.model} ${car.generation}")
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context, id: Long): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(context.getString(R.string.EXTRAS_ID), id)
            return intent
        }
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
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
