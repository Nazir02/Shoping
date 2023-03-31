package com.example.shoping.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getIdList():LiveData<List<ShopItem>>

    fun getShopItem(shopItem: Int):ShopItem
}