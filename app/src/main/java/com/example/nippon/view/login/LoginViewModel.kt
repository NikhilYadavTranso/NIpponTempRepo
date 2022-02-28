package com.example.nippon.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.nippon.repository.UserRepository
import com.example.nippon.model.userLogin.UserLoginModelRequest

class LoginViewModel : ViewModel() {
    val isUserLoggedIn = MutableLiveData<Boolean>()
    val isUserType = MutableLiveData<String>()
    fun loginUser(email: String?, password: String?) {
        val apiService = UserRepository()
        val userInfo = UserLoginModelRequest(
            userEmail = email,
            userPassword = password,
        )

        apiService.loginUser(userInfo) {
            if (it?.userId != null) {
                isUserLoggedIn.value = true
                isUserType.value = it.userType.toString()
            } else {
                //TOdo proper error mapping
                isUserLoggedIn.value = false
            }
        }
    }
}