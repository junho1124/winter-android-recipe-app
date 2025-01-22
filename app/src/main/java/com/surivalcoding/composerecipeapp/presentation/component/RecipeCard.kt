package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

private const val CARD_ASPECT_RATIO_RECTANGLE = 2.1f
private const val CARD_ASPECT_RATIO_SQUARE = 1f
private val CARD_ROUNDNESS = 10.dp

enum class RecipeShape {
    SQUARE, RECTANGLE
}

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    cardShape: RecipeShape = RecipeShape.RECTANGLE,
    onClick: () -> Unit,
    onBookmark: (Int) -> Unit = {},
    isBookmarked: Boolean = false
) {
    val aspectRatio = when (cardShape) {
        RecipeShape.RECTANGLE -> CARD_ASPECT_RATIO_RECTANGLE
        RecipeShape.SQUARE -> CARD_ASPECT_RATIO_SQUARE
    }
    Box(
        modifier = modifier
            .aspectRatio(aspectRatio)
            .clip(RoundedCornerShape(CARD_ROUNDNESS))
            .clickable(
                onClick = onClick
            )
    ) {
        AsyncImage(
            model = if (LocalInspectionMode.current) {
                ColorDrawable(AppColors.gray4.toArgb())
            } else recipe.image,
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            AppColors.transparent,
                            AppColors.black,
                        ),
                        start = Offset(0.5f, 0f),
                        end = Offset(0.5f, 1000f)
                    ),
                    shape = RoundedCornerShape(CARD_ROUNDNESS)
                )
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
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 7.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = AppColors.rating,
                        modifier = Modifier
                            .width(8.dp)
                            .height(8.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(3.dp)
                    )
                    Text(
                        text = recipe.rating.toString(),
                        style = AppTextStyles.smallLabelRegular,
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
                        text = "By ${recipe.chef}",
                        style = AppTextStyles.smallerTextRegular.copy(color = AppColors.gray4)
                    )
                }
                if(cardShape == RecipeShape.RECTANGLE) Row(
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
                            imageVector = Icons.Outlined.Timer,
                            contentDescription = null,
                            tint = AppColors.gray4,
                            modifier = Modifier
                                .size(17.dp)

                        )
                        Box(
                            modifier = Modifier
                                .width(5.dp)
                        )
                        Text(
                            text = "${recipe.time} min",
                            style = AppTextStyles.smallerTextRegular.copy(
                                color = AppColors.gray4,
                            )
                        )
                        Box(
                            modifier = Modifier
                                .width(10.dp)
                        )
                        IconButton(
                            onClick = { onBookmark(recipe.id) },
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    color = AppColors.white,
                                    shape = CircleShape
                                )
                                .padding(horizontal = 5.dp),
                        ) {
                            Icon(
                                imageVector = if (isBookmarked) {
                                    Icons.Default.Bookmark
                                } else {
                                    Icons.Outlined.BookmarkBorder
                                },
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
    var isBookmarked = true
    Column {

        RecipeCard(
            recipe = Recipe.default(),
            onClick = {},
            onBookmark = {
                isBookmarked = !isBookmarked
            },
            isBookmarked = isBookmarked
        )

        RecipeCard(
            recipe = Recipe.default(),
            onClick = {},
            cardShape = RecipeShape.SQUARE,
            onBookmark = {
                isBookmarked = !isBookmarked
            },
            isBookmarked = isBookmarked
        )
    }
}