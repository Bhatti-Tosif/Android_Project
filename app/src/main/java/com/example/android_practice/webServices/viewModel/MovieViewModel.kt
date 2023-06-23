package com.example.android_practice.webServices.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_practice.webServices.instance.MovieInstance
import com.example.android_practice.webServices.model.MovieResult
import com.example.android_practice.webServices.model.Movies
import retrofit2.Call
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<MovieResult>>()

    fun getPopularMovies() {
        MovieInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0").enqueue(object : retrofit2.Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body() != null) {
                    movieLiveData.value = response.body()!!.results
                    Log.d("response", movieLiveData.value.toString())
                } else {
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("API Fail", t.message.toString())
            }
        })
    }

    fun observeMovieLiveData(): LiveData<List<MovieResult>> {
        return  movieLiveData
    }
}