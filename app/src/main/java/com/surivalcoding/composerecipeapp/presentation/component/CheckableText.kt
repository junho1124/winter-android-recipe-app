package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun CheckableText(modifier: Modifier = Modifier, text: String, onChanged: (Boolean) -> Unit = {}) {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(start = 10.dp, top = 20.dp, bottom = 26.dp)
            .clickable(onClick = {
                isChecked = !isChecked
                onChanged(isChecked)
            }),
    ) {
        Icon(
            imageVector = if(isChecked) {
                Icons.Default.CheckBox} else {
                Icons.Default.CheckBoxOutlineBlank
            },
            contentDescription = text, tint = AppColors.secondary100,
            modifier = Modifier.size(17.dp)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Text(text, style = AppTextStyles.smallerTextRegular.copy(color = AppColors.secondary100))
    }
}