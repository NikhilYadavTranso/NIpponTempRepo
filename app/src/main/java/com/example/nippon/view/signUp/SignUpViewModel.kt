package com.example.nippon.view.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nippon.model.userSignup.UserSignupModelRequest
import com.example.nippon.repository.UserRepository

class SignUpViewModel : ViewModel() {
    val isUserSignUp = MutableLiveData<Boolean>()

    fun signUpUser(userName: String, email: String, password: String) {
        val apiService = UserRepository()
        val userInfo = UserSignupModelRequest(
            userUserName =userName,
            userEmail = email,
            userPassword = password,
        )
        apiService.signUpUser(userInfo) {
            if (it?.userId != null) {
                isUserSignUp.value = true
            } else {
                //TOdo proper error mapping
                isUserSignUp.value = false
            }
        }
    }

}