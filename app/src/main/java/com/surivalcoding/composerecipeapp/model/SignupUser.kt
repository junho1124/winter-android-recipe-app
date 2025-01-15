package com.surivalcoding.composerecipeapp.model

interface SignupUser {
    val email: String
    val name: String
    val password: String
    val confirmPassword: String
}