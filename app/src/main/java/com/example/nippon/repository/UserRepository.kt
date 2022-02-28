package com.example.nippon.repository

import com.example.nippon.network.ServiceBuilder
import com.example.nippon.network.UserApi
import com.example.nippon.model.userLogin.UserLoginModelRequest
import com.example.nippon.model.userLogin.UserLoginModelResponse
import com.example.nippon.model.userSignup.UserSignupModelRequest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun loginUser(UserModelRequest: UserLoginModelRequest, onResult:(UserLoginModelResponse?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(UserApi::class.java)
        retrofit.loginUser(UserModelRequest).enqueue(
            object : Callback<UserLoginModelResponse> {
                override fun onFailure(call: Call<UserLoginModelResponse>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<UserLoginModelResponse>, response: Response<UserLoginModelResponse>) {
                    // ToDO - Proper error mapping for difrent status
                    val addedUser = response.body()

                    onResult(addedUser)
                }
            }
        )
    }
    fun signUpUser(UserModelRequest: UserSignupModelRequest, onResult:(UserLoginModelResponse?) -> Unit) {
        // TODO CHANGE THE RESPONSE MODEL
        val retrofit = ServiceBuilder.buildService(UserApi::class.java)
        retrofit.signUpUser(UserModelRequest).enqueue(
            object : Callback<UserLoginModelResponse> {
                override fun onFailure(call: Call<UserLoginModelResponse>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<UserLoginModelResponse>, response: Response<UserLoginModelResponse>) {
                    // ToDO - Proper error mapping for different status
                    val addedUser = response.body()
                    onResult(addedUser)

                }
            }
        )
    }
}