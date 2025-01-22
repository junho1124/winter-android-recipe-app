package com.surivalcoding.composerecipeapp.presentation.search_recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCard
import com.surivalcoding.composerecipeapp.presentation.component.RecipeShape
import com.surivalcoding.composerecipeapp.presentation.component.SearchTextField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SearchRecipesScreen(
    modifier: Modifier = Modifier,
    state: SearchRecipesScreenState,
    onQueryChanged: (String) -> Unit,
    onRecipeClicked: (Int) -> Unit,
    onBookmark: (Int) -> Unit,
    onFilterIconClicked: () -> Unit,
) {
    Column(
        modifier = modifier
            .safeContentPadding()
            .background(color = AppColors.white)
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 30.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = { }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Search Recipes",
                style = AppTextStyles.mediumTextBold,
            )
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(20.dp))
        }
        Spacer(modifier = Modifier.size(17.dp))
        Row {
            SearchTextField(
                modifier = Modifier.weight(1f),
                value = state.query,
                onValueChange = onQueryChanged,
            )
            Spacer(modifier = Modifier.size(20.dp))
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        AppColors.primary100,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable(
                        onClick = onFilterIconClicked
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.FilterList,
                    contentDescription = "Search",
                    tint = AppColors.white,
                    modifier = Modifier.size(20.dp)
                )
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.padding(vertical = 20.dp),
                text = if(state.query.isBlank()) {
                    "Recent Recipes"
                } else {
                    "Search Result"
                },
                style = AppTextStyles.normalTextBold,
            )
            if(state.query.isNotBlank()) Text(
                text = "${state.filteredRecipes.size} results",
                style = AppTextStyles.smallTextRegular.copy(color = AppColors.gray3),
            )
        }
        if(state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.size(40.dp)) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp),
                        color = AppColors.primary100
                    )
                }
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                items(
                    if (state.query.isBlank()) {
                        state.recipes
                    } else {
                        state.filteredRecipes
                    }
                ) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = { onRecipeClicked(recipe.id) },
                        isBookmarked = state.bookmarkRecipeIds.contains(recipe.id),
                        cardShape = RecipeShape.SQUARE,
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun SearchRecipesScreenPreview() {
    SearchRecipesScreen(
        state = SearchRecipesScreenState.initialState(),
        onQueryChanged = {},
        onRecipeClicked = {},
        onFilterIconClicked = {},
        onBookmark = {},
    )
}