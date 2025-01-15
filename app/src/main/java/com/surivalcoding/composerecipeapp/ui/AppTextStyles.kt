package com.surivalcoding.composerecipeapp.ui

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R

object AppTextStyles {
    private val poppinsFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_regular)
    )

    val normalTextBold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
    )

    val kS16LH24 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = poppinsFamily,
    )
    val kS14LH21 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 21.sp,
        fontFamily = poppinsFamily,
    )
    val kS8LH12 = TextStyle(
        fontSize = 8.sp,
        lineHeight = 12.sp,
        fontFamily = poppinsFamily,
    )


}