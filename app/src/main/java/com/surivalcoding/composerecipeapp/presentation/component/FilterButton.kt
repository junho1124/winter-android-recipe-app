package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun FilterButton(modifier: Modifier = Modifier, buttonText: String, icon: ImageVector? = null) {
    var isSelect by remember { mutableStateOf(false) }

    TextButton(
        onClick = {
            isSelect = !isSelect
        },
        modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .background(
                color = if (isSelect) {
                    AppColors.primary100
                } else AppColors.white,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.primary100,
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Text(
            buttonText,
            modifier = modifier,
            style = AppTextStyles.smallerTextRegular.copy(
                color = if (isSelect) {
                    AppColors.white
                } else AppColors.primary100
            )
        )
        if(icon != null) {
            Box(
                modifier = Modifier.padding(start = 5.dp)
            )
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isSelect) {
                    AppColors.white
                } else AppColors.primary100,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterButtonPreview() {
    Column {
        FilterButton(buttonText = "Filter")
        Row {

            arrayOf("1", "2", "3", "4", "5").forEach {
                FilterButton(buttonText = it, icon = Icons.Default.Star)
            }
        }
    }
}