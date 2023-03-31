package com.example.shoping.domain

import androidx.lifecycle.LiveData

class GetIdShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> = shopListRepository.getIdList()
}