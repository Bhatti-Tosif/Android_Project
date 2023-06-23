package com.example.android_practice.webServices.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    val createdAt: String,
    val name: String,
    val avatar: String,
    @SerializedName("emailId")
    val emailId: String,
    val id: String
)