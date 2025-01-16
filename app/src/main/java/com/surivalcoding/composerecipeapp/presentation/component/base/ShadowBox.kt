package com.surivalcoding.composerecipeapp.presentation.component.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun ShadowBox(modifier: Modifier = Modifier, onClick: () -> Unit = {}, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 5.dp, // Blur에 해당
                shape = RoundedCornerShape(8.dp), // 모서리가 둥근 경우
                clip = false // 그림자가 확장되도록
            )
            .background(
                color = AppColors.white, // 본체 색상
                shape = RoundedCornerShape(8.dp)
            )
            .padding(3.dp)
            .then(modifier)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}