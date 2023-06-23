package com.example.android_practice.webServices.reposetry

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_practice.webServices.api.UserAPI
import com.example.android_practice.webServices.instance.RetrofitHelper
import com.example.android_practice.webServices.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class UserRepository(private val userServices: UserAPI) {

    private val userData = MutableLiveData<ArrayList<UserModel>>()
    val user: LiveData<ArrayList<UserModel>>
        get() = userData

    var newUser = MutableLiveData<UserModel>()

    val createdUser: LiveData<UserModel>
        get() = newUser
    suspend fun getUser() {
        val result = userServices.getUserDetail()
        if (result.body() != null) {
            userData.postValue(result.body())
        }
    }

    suspend fun createUser(user: UserModel) {
        val result  = userServices.createUser(user)
        if (result.body() != null) {
            withContext(Dispatchers.Main) {
                newUser.value = result.body()
            }
        } else {
            Log.d(TAG, "Created Response NULL")
        }
    }
}

object UserMainRepository {
    fun updateUser(params: HashMap<String, String>, id: String): Call<UserModel> {
        return RetrofitHelper.getUserInstance().updateUSer(id, params)
    }

    fun deleteUser(id: String): Call<UserModel> {
        return  RetrofitHelper.getUserInstance().deleteUser(id)
    }

    fun searchUser(searchText: String): Call<ArrayList<UserModel>> {
        return RetrofitHelper.getUserInstance().searchUser(searchText)
    }

/** This is for Practice
//    fun uploadImage() : Response<UploadImageResponse> {
//        return  RetrofitHelper.uploadInstance().uploadImage()
//    }  */
}