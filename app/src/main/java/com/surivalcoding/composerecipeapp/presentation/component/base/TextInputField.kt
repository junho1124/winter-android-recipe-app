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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun TextInputField(modifier: Modifier = Modifier, label: String, hint: String, initialValue: String = "", visualTransformation: VisualTransformation? = null, onValueChange: (String) -> Unit = {}) {
    var value by remember { mutableStateOf(initialValue) }
    Column(modifier) {
        Text(label, style = AppTextStyles.smallTextRegular)
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = value,
            onValueChange = {
                value = it
                onValueChange(it)
            },
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

@Preview
@Composable
private fun TextInputFieldPreview() {
    Column {
        TextInputField(
            label = "Name",
            hint = "Enter Name",
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextInputField(
            label = "Password",
            hint = "Enter Password",
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {}
        )
    }

}