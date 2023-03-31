package com.example.shoping.domain

data class ShopItem(
    var name:String,
    var count:Int,
    var enable:Boolean,
    var id:Int= UNDEFOUND_ID
    ){
    companion object{
        const val UNDEFOUND_ID=-1
    }
}
