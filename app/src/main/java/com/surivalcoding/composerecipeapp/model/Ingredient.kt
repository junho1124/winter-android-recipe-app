package com.surivalcoding.composerecipeapp.model

data class Ingredient(
    val name: String,
    val amount: Int,
    val imageUrl: String
) {
    companion object {
        fun default() = Ingredient(
            name = "Tomatos",
            amount = 500,
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjiaCX1MjfEnom-gEbNT2IQZW1qlPbBnjDlCxyz7mqGn2u9VA_fPZ7mzX9cogw-kLKGvJl3WvTx5ZW5MEsYLrP3A"
        )
    }
}

