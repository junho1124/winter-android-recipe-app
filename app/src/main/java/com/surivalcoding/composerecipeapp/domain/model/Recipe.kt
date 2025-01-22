package com.surivalcoding.composerecipeapp.domain.model

data class Recipe(
    val category: String,
    val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Float,
    val ingredients: List<Ingredient>
) {
    companion object {
        fun default() = Recipe(
            category = "Default Category",
            id = 0,
            name = "Default Recipe",
            image = "https://example.com/default_image.png",
            chef = "Default Chef",
            time = "0 min",
            rating = 0.0f,
            ingredients = listOf(
                Ingredient.default()
            )
        )
    }
}