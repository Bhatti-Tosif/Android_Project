package com.example.android_practice.webServices.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_practice.webServices.reposetry.UserRepository
import com.example.android_practice.webServices.viewModel.UserViewModel

class UserViewModelFactory(private val repository: UserRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}