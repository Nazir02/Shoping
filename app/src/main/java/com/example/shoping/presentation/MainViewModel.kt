package com.example.shoping.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoping.data.ShopListRepositoryImpl
import com.example.shoping.domain.*

class MainViewModel:ViewModel() {

    private val repository=ShopListRepositoryImpl
    private val getShopListUseCase=GetIdShopItemUseCase(repository)
    private val deleteShopItemUseCase=DeleteShopItemUseCase(repository)
    private val editShopItemUseCase=EditShopItemUseCase(repository)

    val shopList=getShopListUseCase.getShopList()



    fun deleteShopList(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }
    fun changeEnableShopItem(shopItem: ShopItem){
        val newItem=shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)


    }
}