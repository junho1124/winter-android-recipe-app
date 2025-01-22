package com.surivalcoding.composerecipeapp.domain.model

data class Chef(
    val id: Int,
    val name: String,
    val image: String,
    val address: String,
) {
    companion object {
        fun default() = Chef(
            id = 1,
            name = "Chef John",
            image = "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png",
            address = "Lagos, Nigeria"
        )
    }
}