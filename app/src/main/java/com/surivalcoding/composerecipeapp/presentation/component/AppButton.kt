package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

enum class ButtonShape {
    BIG,
    MEDIUM,
    SMALL
}
@Composable
fun AppButton(modifier: Modifier = Modifier, shape: ButtonShape, text: String, onClick: () -> Unit = {}) {
    var isPressed by remember { mutableStateOf(false) }
    val defaultModifier = Modifier
        .background(
            color = if (isPressed) {
                AppColors.gray4
            } else {
                AppColors.primary100
            },
            shape = RoundedCornerShape(10.dp)
        )
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    isPressed = true
                    onClick()
                    tryAwaitRelease()
                    isPressed = false
                }
            )
        }
    val sizeModifier = when(shape) {
        ButtonShape.BIG -> {
            Modifier
                .fillMaxWidth()
                .height(60.dp)
        }
        ButtonShape.MEDIUM -> {
            Modifier.size(243.dp, 54.dp)
        }
        ButtonShape.SMALL -> {
            Modifier.size(174.dp, 37.dp)
        }
    }

    val textStyle = when(shape) {
        ButtonShape.BIG, ButtonShape.MEDIUM -> {
            AppTextStyles.normalTextBold.copy(fontWeight = FontWeight.W600, color = AppColors.white)
        }
        ButtonShape.SMALL -> {
            AppTextStyles.smallTextBold.copy(color = AppColors.white, fontWeight = FontWeight.W600)
        }
    }
    Box(
        modifier = defaultModifier
            .then(sizeModifier)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 50.dp)
        ) {
            Text(
                text = text,
                style = textStyle,
                modifier = Modifier.width(114.dp)
            )
            if(shape != ButtonShape.SMALL) {
                Box(
                    modifier = Modifier.width(if(shape == ButtonShape.MEDIUM) {
                        9.dp
                    } else {
                        11.dp
                    })
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = AppColors.white,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun AppButtonPreview() {
    Column {
         AppButton(shape = ButtonShape.BIG, text = "Button")
        AppButton(shape = ButtonShape.MEDIUM, text = "Button")
        AppButton(shape = ButtonShape.SMALL, text = "Button")
    }
}