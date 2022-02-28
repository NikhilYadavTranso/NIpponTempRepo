package com.example.nippon.model.userSignup

import com.google.gson.annotations.SerializedName

data class UserSignupModelRequest (
    @SerializedName("user_username") val userUserName: String?,
    @SerializedName("user_email") val userEmail: String?,
    @SerializedName("user_password") val userPassword: String?,
)