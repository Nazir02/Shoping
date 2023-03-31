package com.example.shoping.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItem: Int):ShopItem = shopListRepository.getShopItem(shopItem)

}