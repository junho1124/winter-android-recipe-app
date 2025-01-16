package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

// 상수로 스타일 관리
private val DIALOG_PADDING = 15.dp
private val DIALOG_SHADOW_ELEVATION = 2.dp
private val DIALOG_CORNER_RADIUS = 8.dp
private val STAR_SIZE = 24.dp
private val STAR_PADDING = 5.dp
private val BUTTON_SIZE = 61.dp to 30.dp
private val BUTTON_CORNER_RADIUS = 6.dp

@Composable
fun RatingDialog(
    modifier: Modifier = Modifier,
    initialRate: Int = 0, // 초기 별점 0 (모두 비어있는 별)
    onRateSelected: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    var rate by remember { mutableStateOf(initialRate) }

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(DIALOG_PADDING)
                .shadow(DIALOG_SHADOW_ELEVATION, RoundedCornerShape(DIALOG_CORNER_RADIUS))
                .clip(RoundedCornerShape(DIALOG_CORNER_RADIUS))
                .background(AppColors.white)
                .padding(horizontal = DIALOG_PADDING, vertical = 10.dp)
        ) {
            // 제목
            Text(
                "Rate recipe",
                style = AppTextStyles.smallTextRegular.copy(
                    color = AppColors.labelColor,
                    fontWeight = FontWeight.W400
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 별점 선택 Row
            StarRatingRow(rate = rate, onRateChange = {
                rate = it
            })

            Spacer(modifier = Modifier.height(16.dp))

            // 확인 버튼
            Box(
                modifier = Modifier
                    .size(BUTTON_SIZE.first, BUTTON_SIZE.second)
                    .background(
                        if (rate != 0) {
                            AppColors.primary100
                        } else {
                            AppColors.gray4
                        }, RoundedCornerShape(BUTTON_CORNER_RADIUS)
                    )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                onRateSelected(rate) // 별점 결과 반환
                                onDismiss() // Dialog 닫기
                            }
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Send",
                    style = AppTextStyles.smallLabelRegular.copy(
                        color = AppColors.white,
                        fontWeight = FontWeight.W400,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@Composable
fun StarRatingRow(rate: Int, onRateChange: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        (1..5).forEach { i ->
            Box(
                modifier = Modifier
                    .padding(STAR_PADDING)
                    .pointerInput(Unit) {
                        detectTapGestures(onPress = { onRateChange(i) })
                    }
            ) {
                Icon(
                    imageVector = if (i <= rate) Icons.Default.Star else Icons.Outlined.StarOutline,
                    contentDescription = null,
                    tint = AppColors.rating,
                    modifier = Modifier.size(STAR_SIZE)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingDialogPreview() {
    RatingDialog(
        initialRate = 0, // 초기 별점 0 (모두 비어 있는 별)
        onRateSelected = { rate ->
            println("Selected Rate: $rate")
        },
        onDismiss = {
            println("Dialog dismissed")
        }
    )
}
