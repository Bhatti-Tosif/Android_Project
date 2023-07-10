package com.example.android_practice.webServices.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.android_practice.webServices.Utils.AppConstant
import com.example.android_practice.webServices.Utils.Event
import com.example.android_practice.webServices.api.RequestHandler
import com.example.android_practice.webServices.model.UserModel
import com.example.android_practice.webServices.reposetry.UserMainRepository
import com.example.android_practice.webServices.reposetry.UserRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class UserViewModel(private val repository: UserRepository): ViewModel() {

    /** Initializer for UserViewModel */
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUser()
        }
    }

    /** Live Data Properties */
    var showUser = MutableLiveData<Event<UserModel>>()
    val deleteUser = MutableLiveData<UserModel>()
    var deleteUserSuccess = MutableLiveData<Int>()
    val okHttpResponse = MutableLiveData<Array<UserModel>>()
    val volleyResponse = MutableLiveData<Array<UserModel>>()
    val user: LiveData<ArrayList<UserModel>>
        get() = repository.user
    val createdUser: LiveData<UserModel>
        get() = repository.createdUser
    val updateResponseData: MutableLiveData<Pair<Int, UserModel?>> = MutableLiveData()

    val searchedUsers = MutableLiveData<MutableList<UserModel>>()

    /** update User Detail using HashMap Param */
    fun updateUser(params: HashMap<String, String>, position: Int, id: String) {

        UserMainRepository.updateUser(params, id).enqueue(object : Callback<UserModel> {

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    updateResponseData.value = Pair(position, response.body())
                } else {
                    Log.d(TAG, "User Response Fail")
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d(TAG, "Error From API")
            }
        })
    }

    /** Delete User Using Retrofit*/
    fun deleteUser(id: String, position: Int) {

        UserMainRepository.deleteUser(id).enqueue(object : Callback<UserModel> {

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    deleteUser.value = response.body()
                    deleteUserSuccess.value = position
                } else {
                    Log.d(TAG, "Fail In Response")
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d(TAG, "API Call Fail")
            }
        })
    }

    /** Create New User Using API Calling*/
    suspend fun createUser(userData: UserModel) {
        repository.createUser(userData)
    }

    /**  GetUser List Using through HTTPURLRequestConnection */
    fun getUserThroughHttp(path: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val response = RequestHandler.requestGET(AppConstant.BASE_USER_URL + path)

            /**This is for my Practice
            //Using Gson for Json Parsing
            //val gsonParsing = Gson().fromJson(response, UserModel::class.java)
            //Log.d(TAG, gsonParsing.toString())  */

            //Manual Json Parsing
            val json = JSONObject(response)
            val user = UserModel( json.getString(AppConstant.createdAt) ?: "",
            json.getString(AppConstant.name) ?: "",
            json.getString(AppConstant.avatar) ?: "",
                (json.get(AppConstant.emailId) ?: "") as String,
                (json.get(AppConstant.id) ?: "") as String
            )
            withContext(Dispatchers.Main) {
                showUser.value = Event(user)
            }
        }
    }

    /** GetUser List Through OKHttp Library for Practice */
    fun getUserThroughOkHttp(path: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(AppConstant.BASE_USER_URL + path)
            .get()
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback{
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.d(TAG, "Error: ${e.message}")
            }
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful ) {
                    val result = response.body()?.string()
                    if (result != null) {
                        val json = Gson().fromJson(result, Array<UserModel>::class.java)
                        Log.d("Response", json.toString())
                        viewModelScope.launch {
                            okHttpResponse.value = json
                        }
                    }
                } else {
                    Log.d(TAG, "Error in Response")
                }
            }
        })
    }

    /** GetUser List Through Volley Library  */
    fun getDataThroughVolley(queue: RequestQueue, path: String) {
        val stringReq = StringRequest(com.android.volley.Request.Method.GET, AppConstant.BASE_USER_URL + path,
            { response ->
                val result = response.toString()
                Log.d("Volley", response.toString())
                val json = Gson().fromJson(result, Array<UserModel>::class.java)
                volleyResponse.value = json
            },
            {
                Log.d("ERROR:", "API Didn't work")
            })
        queue.add(stringReq)
    }

    /** Search User Using Query text  */
    fun searchUser(query: String) {
        UserMainRepository.searchUser(query).enqueue(object : Callback<ArrayList<UserModel>> {

            override fun onResponse(
                call: Call<ArrayList<UserModel>>,
                response: Response<ArrayList<UserModel>>
            ) {
                if (response.isSuccessful) {
                    searchedUsers.value = response.body()
                } else {
                    Log.d("API", "Error in search Response")
                }
            }

            override fun onFailure(call: Call<ArrayList<UserModel>>, t: Throwable) {
                Log.d("API", "Error in From server ")
            }
        })
    }
}