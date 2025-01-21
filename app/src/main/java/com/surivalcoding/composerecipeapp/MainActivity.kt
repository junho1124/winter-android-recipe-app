package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreenViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val savedRecipesScreenViewModel: SavedRecipesScreenViewModel by viewModels {
                SavedRecipesScreenViewModel.Factory
            }
            val state = savedRecipesScreenViewModel.state.collectAsStateWithLifecycle().value
            ComposeRecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SavedRecipesScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = state,
                        onClickRecipe = savedRecipesScreenViewModel::onRecipeClicked,
                        onBookmark = savedRecipesScreenViewModel::onBookmark
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