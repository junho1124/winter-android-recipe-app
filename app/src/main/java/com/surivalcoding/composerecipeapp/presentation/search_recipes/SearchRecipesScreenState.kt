package com.surivalcoding.composerecipeapp.presentation.search_recipes

import com.surivalcoding.composerecipeapp.core.presentation.ViewStateable
import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SearchRecipesScreenState(
    val query: String = "",
    val searchFilter: SearchFilter = SearchFilter.default(),
    val recipes: List<Recipe> = emptyList(),
    val bookmarkRecipeIds: Set<Int> = emptySet(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val showBottomSheet: Boolean = false,
    val isLoading: Boolean = true,
) : ViewStateable() {
    companion object {
        fun initialState() = SearchRecipesScreenState()
    }
}

data class SearchFilter(
    val timeFilter: TimeFilter = TimeFilter.ALL,
    val rateFilter: Int = 5,
    val category: String = "",
) {
    companion object {
        fun default() = SearchFilter()
    }
}


enum class TimeFilter(val value: String) {
    ALL("All"),
    NEWEST("Newest"),
    OLDEST("Oldest"),
    POPULARITY("Popularity");
}

