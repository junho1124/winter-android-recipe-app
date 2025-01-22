package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreenEvent
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreenViewModel
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecipeAppTheme {
                val viewModel = get<SearchRecipesScreenViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier
                    .background(color = AppColors.white)
                    .fillMaxSize()) { innerPadding ->
                    SearchRecipesScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = state,
                        onQueryChanged = {
                            viewModel.onEvent(SearchRecipesScreenEvent.SearchRecipes(it))
                        },
                        onRecipeClicked = {
                            viewModel.onEvent(SearchRecipesScreenEvent.NavigateToRecipeDetail(it))
                        },
                        onFilterIconClicked = {
                            viewModel.onEvent(SearchRecipesScreenEvent.ToggleFilterBottomSheet)
                        },
                        onDismissBottomSheet = {
//                            viewModel.onEvent(SearchRecipesScreenEvent.ToggleFilterBottomSheet)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainActivity()
}