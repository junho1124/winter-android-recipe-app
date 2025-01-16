package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

private const val CARD_ASPECT_RATIO = 2.1f
private val CARD_ROUNDNESS = 10.dp

@Composable
fun RecipeCard(modifier: Modifier = Modifier, recipe: Recipe) {
    Box(
        modifier = modifier
            .aspectRatio(CARD_ASPECT_RATIO)
            .clip(RoundedCornerShape(CARD_ROUNDNESS))
    ) {
        AsyncImage(
            model = if (LocalInspectionMode.current) {
                ColorDrawable(AppColors.gray4.toArgb())
            } else recipe.thumbnailImageUrl,
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 7.dp)
                    .align(Alignment.End)
                    .background(
                        color = AppColors.secondary20,
                        shape = RoundedCornerShape(20.dp)
                    ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 7.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = AppColors.rating,
                        modifier = Modifier
                            .width(7.5.dp)
                            .height(7.dp)
                    )
                    Box(
                        modifier = Modifier
                            .width(3.dp)
                    )
                    Text(
                        text = recipe.rate.toString(),
                        style = AppTextStyles.smallerTextRegular,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(

                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = recipe.name + recipe.name,
                        style = AppTextStyles.smallTextBold.copy(color = AppColors.white),
                    )
                    Text(
                        text = "By ${recipe.authorName}",
                        style = AppTextStyles.smallerTextRegular.copy(color = AppColors.gray4)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.End
                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Icon(
                            /// timer icon
                            imageVector = Icons.Default.Face,
                            contentDescription = null,
                            tint = AppColors.white,
                            modifier = Modifier
                                .size(17.dp)

                        )
                        Box(
                            modifier = Modifier
                                .width(5.dp)
                        )
                        Text(
                            text = "${recipe.timeTaken} min",
                            style = AppTextStyles.smallerTextRegular.copy(
                                color = AppColors.white,
                            )
                        )
                        Box(
                            modifier = Modifier
                                .width(10.dp)
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    color = AppColors.white,
                                    shape = CircleShape
                                )
                                .padding(horizontal = 5.dp),
                        ) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = null,
                                    tint = AppColors.primary80,
                                    modifier = Modifier
                                        .size(17.dp),
                                )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        recipe = Recipe.default()
    )
}