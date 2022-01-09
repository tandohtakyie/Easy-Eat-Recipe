package com.gabriel.easy_eat_recipe.data

import com.gabriel.easy_eat_recipe.data.network.FoodRecipesApi
import com.gabriel.easy_eat_recipe.model.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    /**
     * looking for a method which returns FoodRecipesApi
     * inside the NetworkModule object class
     * and that is the provideApiService method
     */
    private val foodRecipesApi: FoodRecipesApi
) {
    suspend fun getRecipes(queries: Map<String, String>) : Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}