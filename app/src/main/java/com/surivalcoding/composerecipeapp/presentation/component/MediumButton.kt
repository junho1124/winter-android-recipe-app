package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MediumButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    AppButton(
        modifier = modifier,
        shape = ButtonShape.MEDIUM,
        text = text,
        onClick = onClick
    )
}

@Preview
@Composable
private fun MediumButtonPreview() {
    MediumButton(
        text = "Button"
    )
}