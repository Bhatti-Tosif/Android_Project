package com.example.android_practice.webServices.model.response

import com.google.gson.annotations.SerializedName

data class UploadImageResponse(
   val accountId: String,
   val filePath: String,
   @SerializedName("fileUrl")
   val fileUrl: String
)