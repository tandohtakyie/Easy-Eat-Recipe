package com.gabriel.easy_eat_recipe.data.network

import com.gabriel.easy_eat_recipe.model.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {

    /**
     * This method returns a list of Food Recipes which are fetched in the api
     * Using suspend method because this method will use kotlin Coroutine
     * It will run on a background thread instead of the Main thread
     */
    @GET("/recipes/complexSearch")
    suspend fun getRecipes(@QueryMap queries: Map<String, String>): Response<FoodRecipe>
}