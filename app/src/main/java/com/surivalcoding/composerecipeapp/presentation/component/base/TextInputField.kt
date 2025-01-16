package com.surivalcoding.composerecipeapp.presentation.component.base

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun TextInputField(modifier: Modifier = Modifier, label: String, hint: String, visualTransformation: VisualTransformation? = null, onValueChange: (String) -> Unit = {}) {
    Column {
        Text(label, style = AppTextStyles.smallTextRegular)
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = "",
            onValueChange = onValueChange,
            placeholder = { Text(hint, style = AppTextStyles.smallerTextRegular.copy(color = AppColors.gray4)) },
            colors = TextFieldDefaults.colors(
                disabledContainerColor = AppColors.white,
                unfocusedContainerColor = AppColors.white,
            ),
            visualTransformation = visualTransformation ?: VisualTransformation.None,
            modifier = Modifier
                .background(color = AppColors.white)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .border(1.5.dp, AppColors.gray4, RoundedCornerShape(10.dp))
        )
    }
}