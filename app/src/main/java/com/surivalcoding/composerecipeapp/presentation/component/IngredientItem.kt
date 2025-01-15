package com.surivalcoding.composerecipeapp.presentation.component

import android.icu.text.ListFormatter
import android.text.style.LineHeightSpan
import androidx.annotation.Px
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.model.Ingredient
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun IngredientItem(modifier: Modifier = Modifier, ingredient: Ingredient) {
    Box(
        modifier
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = CenterVertically,
        ) {
            AsyncImage(
                model = if (ingredient.imageUrl.isEmpty()) "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjiaCX1MjfEnom-gEbNT2IQZW1qlPbBnjDlCxyz7mqGn2u9VA_fPZ7mzX9cogw-kLKGvJl3WvTx5ZW5MEsYLrP3A" else ingredient.imageUrl,
                contentDescription = "Image of ${ingredient.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp)
                    .background(AppColors.withe, RoundedCornerShape(10.dp))
            )
            Box(
                modifier = Modifier.width(15.dp)
            )
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                Text(
                    ingredient.name,
                    modifier.weight(1f),
                    style = AppTextStyles.kS16LH24.copy(fontWeight = FontWeight.W600)
                )
                Text("${ingredient.amount}g", style = AppTextStyles.kS16LH24.copy(color = AppColors.textGrey))

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = Ingredient(
            name = "Tomatos",
            amount = 500,
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjiaCX1MjfEnom-gEbNT2IQZW1qlPbBnjDlCxyz7mqGn2u9VA_fPZ7mzX9cogw-kLKGvJl3WvTx5ZW5MEsYLrP3A"
        )
    )
}