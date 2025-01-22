package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.data_source.local.MockBookmarkDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.remote.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCard
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SavedRecipesScreen(
    modifier: Modifier = Modifier,
    state: SavedRecipesScreenState,
    onClickRecipe: (Recipe) -> Unit,
    onBookmark: (Recipe) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = AppColors.white)
            .padding(vertical = 10.dp, horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Text("Saved Recipes", style = AppTextStyles.mediumTextBold)
            Spacer(modifier = Modifier.height(10.dp))
        if (state.isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
                color = AppColors.primary100
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                content = {
                    items(state.recipes.size) {
                        RecipeCard(
                            modifier = Modifier.padding(vertical = 10.dp),
                            recipe = state.recipes[it],
                            onClick = {
                                onClickRecipe(state.recipes[it])
                            },
                            onBookmark = {
                                onBookmark(state.recipes[it])
                            }
                        )
                    }
                }
            )

        }
    }
}

@Preview
@Composable
private fun SavedRecipesScreenPreview() {
    val recipeRepository = RecipeRepositoryImpl(
        recipeDataSource = MockRecipeDataSourceImpl(),
        bookmarkDataSource = MockBookmarkDataSourceImpl()
    )

    val recipes = recipeRepository.getSavedRecipes()
    SavedRecipesScreen(
        state = SavedRecipesScreenState.initialState(),
        onClickRecipe = {},
        onBookmark = {})
}