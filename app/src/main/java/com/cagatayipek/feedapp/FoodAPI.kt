package com.cagatayipek.feedapp

import retrofit2.Response
import retrofit2.http.GET

interface FoodAPI {
    @GET("kodecocodes/recipes/master/Recipes.json")
    suspend fun getData():Response<List<FoodModel>>
}