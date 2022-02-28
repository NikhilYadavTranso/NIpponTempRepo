package com.example.nippon.network

import com.example.nippon.model.userLogin.UserLoginModelRequest

import com.example.nippon.model.userLogin.UserLoginModelResponse
import com.example.nippon.model.userSignup.UserSignupModelRequest
import com.example.nippon.utility.Constants

import retrofit2.Call
import retrofit2.http.*

interface UserApi {

    @Headers("Content-Type: application/json")
    @POST(Constants.Url.login)
    fun loginUser(@Body UserModelRequest: UserLoginModelRequest): Call<UserLoginModelResponse>


    @POST(Constants.Url.signUp)
    fun signUpUser(@Body UserModelRequest: UserSignupModelRequest): Call<UserLoginModelResponse>
}