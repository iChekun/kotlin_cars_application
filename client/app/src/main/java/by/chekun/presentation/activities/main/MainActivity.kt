package by.chekun.presentation.activities.main

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import by.chekun.R
import by.chekun.di.component.ViewModelComponent
import by.chekun.domain.AllCarsViewModel
import by.chekun.presentation.activities.detail.DetailActivity
import by.chekun.presentation.adapter.CarAdapter
import by.chekun.presentation.base.BaseActivity
import by.chekun.presentation.item.CarItemClickListener
import by.chekun.repository.database.entity.Car


import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    var viewModel: AllCarsViewModel? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel?.getAllItems()
        viewModel?.getLiveDataItems()?.observe(this, Observer { it?.let { initRecyclerView(it) } })
    }

    private fun initRecyclerView(users: List<Car>) {
        val manager = LinearLayoutManager(this)
        val userAdapter = CarAdapter(this, users, itemClickListener)
        userAdapter.setItemClickListener(itemClickListener)
        rvUsers.layoutManager = manager
        rvUsers.adapter = userAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    private val itemClickListener = object : CarItemClickListener<Car> {
        override fun openDetail(entity: Car) {
            openItemDetail(entity.id)
        }
    }


    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }


    private fun openItemDetail(id: Long) {
        this.startActivity(DetailActivity.newInstance(this, id))
    }
}
