package com.gabriel.easy_eat_recipe.di

import com.gabriel.easy_eat_recipe.data.network.FoodRecipesApi
import com.gabriel.easy_eat_recipe.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Using application scope for the api
     * Annotating it with @Provides because
     * of the use of the third-party library OkHttpClient
     */
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS).build()
    }

    /**
     * Using application scope for the api
     * Annotating it with @Provides because
     * of the use of the third-party library GsonConverterFactory
     */
    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    /**
     * Using application scope for the api
     * Annotating it with @Provides because
     * of the use of the third-party library Retrofit and GsonConverterFactory
     */
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(gsonConverterFactory).build()
    }

    /**
     * Using application scope for the api
     * Annotating it with @Provides because
     * of the use of the third-party library Retrofit
     */
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): FoodRecipesApi {
        return retrofit.create(FoodRecipesApi::class.java)
    }
}