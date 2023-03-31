package com.example.shoping.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoping.domain.ShopItem
import com.example.shoping.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private var shopList = mutableListOf<ShopItem>()
    private var autoIncrementID = 0

    init {
        for (i in 0 until 1000){
            val item=ShopItem("Name $i",i,true)
            addShopItem(item)
        }
    }


    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFOUND_ID) {
            shopItem.id = autoIncrementID++
        }
        shopList.add(shopItem)
        upDateList()
    }


    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        upDateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)

    }

    override fun getIdList(): LiveData<List<ShopItem>> {
        return shopListLD

    }

    override fun getShopItem(shopItem: Int): ShopItem {
        return shopList.find { it.id == shopItem }
            ?: throw  RuntimeException("$shopItem id not fount")
    }

    private fun upDateList() {
        shopListLD.value = shopList.toList()
    }
}