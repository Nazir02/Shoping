package com.example.shoping.presentation

import android.content.Context
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoping.R


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            mainAdapter.shopList = it
        }


        initRecyclerView()
    }

    private fun initRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rvShop)
        mainAdapter = ShopListAdapter()

        with(rvShopList) {
            adapter = mainAdapter
            recycledViewPool.setMaxRecycledViews(ShopListAdapter.vtEnable, ShopListAdapter.max_pool)
            recycledViewPool.setMaxRecycledViews(ShopListAdapter.vtDisable, ShopListAdapter.max_pool)
        }

       mainAdapter.onShopLongClick={
           viewModel.changeEnableShopItem(it)
       }
    }




}