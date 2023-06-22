package com.example.android_practice.webServices.api

import com.example.android_practice.webServices.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("3/movie/popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>
}