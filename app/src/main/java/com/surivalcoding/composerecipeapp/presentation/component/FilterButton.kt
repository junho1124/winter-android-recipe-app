package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    isSelected: Boolean,
    onClickButton: () -> Unit,
    icon: ImageVector? = null,
) {

    Box(
        modifier
            .clickable(onClick = onClickButton)
            .defaultMinSize(minHeight = 28.dp)
            .background(
                color = if (isSelected) {
                    AppColors.primary100
                } else AppColors.white,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.primary100,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 5.dp, horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                buttonText,
                style = AppTextStyles.smallerTextRegular.copy(
                    color = if (isSelected) {
                        AppColors.white
                    } else AppColors.primary100
                )
            )
            if (icon != null) {
                Box(
                    modifier = Modifier.padding(start = 5.dp)
                )
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isSelected) {
                        AppColors.white
                    } else AppColors.primary100,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterButtonPreview() {
    Column {
        FilterButton(
            buttonText = "Filter",
            onClickButton = {},
            isSelected = false
        )
        Row {

            arrayOf("1", "2", "3", "4", "5").forEach {
                FilterButton(
                    buttonText = it,
                    icon = Icons.Default.Star,
                    onClickButton = {},
                    isSelected = false
                )
            }
        }
    }
}