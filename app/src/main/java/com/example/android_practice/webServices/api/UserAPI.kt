package com.example.android_practice.webServices.api

import com.example.android_practice.webServices.model.UserModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

/** Retrofit Through API Manager  */
interface UserAPI {
    @GET("student")
    suspend fun getUserDetail(): Response<ArrayList<UserModel>>

    @POST("student")
    suspend fun createUser(@Body userDetail: UserModel): Response<UserModel>

    @PUT("student/{id}")
    fun updateUSer(@Path("id") id: String, @Body params: HashMap<String, String>): Call<UserModel>

    @DELETE("student/{id}")
    fun deleteUser(@Path("id") id: String): Call<UserModel>

    @GET("student")
    fun searchUser(@Query("search") searchText: String): Call<ArrayList<UserModel>>

    /**  Practice purpose
    @Multipart
    @POST("")
    fun uploadImage(@Part image: MultipartBody.Part): Response<UploadImageResponse>  */
}