package com.example.android_practice.webServices.Utils

import com.example.android_practice.webServices.api.UserAPI
import com.example.android_practice.webServices.instance.RetrofitHelper
import com.example.android_practice.webServices.reposetry.UserRepository

object AppConstant {

    const val baseURLMovie: String = "https://api.themoviedb.org/"
    const val BASE_USER_URL: String = "https://648848720e2469c038fd65c3.mockapi.io/api/"
    const val UPLOAD_BASE_URL: String = "https://api.upload.io/v2/accounts/FW25bQv/uploads/form_data"

    private val userServices: UserAPI = RetrofitHelper.getUserInstance()
    val userRepository = UserRepository(userServices)

    //User Model Json Params
    const val createdAt = "createdAt"
    const val name      = "name"
    const val avatar    = "avatar"
    const val emailId   = "emailId"
    const val id        = "id"
}