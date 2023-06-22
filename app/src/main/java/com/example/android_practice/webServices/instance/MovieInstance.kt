package com.example.android_practice.webServices.instance

import com.example.android_practice.webServices.Utils.AppConstant
import com.example.android_practice.webServices.api.MovieApi
import com.example.android_practice.webServices.api.UserAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieInstance {

    val api : MovieApi by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstant.baseURLMovie)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}

object RetrofitHelper {

    fun getUserInstance(): UserAPI {
        return  Retrofit.Builder()
            .baseUrl(AppConstant.BASE_USER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }

    fun uploadInstance(): UserAPI {
        return Retrofit.Builder()
            .baseUrl(AppConstant.UPLOAD_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}