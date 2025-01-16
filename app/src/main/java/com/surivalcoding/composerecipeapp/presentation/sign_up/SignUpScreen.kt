package com.surivalcoding.composerecipeapp.presentation.sign_up

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.CheckableText
import com.surivalcoding.composerecipeapp.presentation.component.base.TextInputField
import com.surivalcoding.composerecipeapp.presentation.sign_in.OrSignInWith
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = AppColors.white)
            .padding(horizontal = 30.dp, vertical = 10.dp)
    ) {
        Text("Create an account", style = AppTextStyles.largeTextBold)
        Spacer(modifier = Modifier.height(5.dp))
        Text("Let’s help you set up your account, \nit won’t take long.", style = AppTextStyles.smallerTextRegular)
        Spacer(modifier = Modifier.height(20.dp))
        TextInputField(label = "Name", hint = "Enter Name", onValueChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        TextInputField(label = "Email", hint = "Enter Email", onValueChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        TextInputField(label = "Password", hint = "Enter Password", visualTransformation = PasswordVisualTransformation(), onValueChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        TextInputField(label = "Confirm Password", hint = "Retype Password", visualTransformation = PasswordVisualTransformation(), onValueChange = {})
        CheckableText(
            text = "Accept terms & Condition",
            onChanged = {}
        )
        BigButton(text = "Sign Up", onClick = {})
        Spacer(modifier = Modifier.height(14.dp))
        OrSignInWith(
            onClickFacebook = {},
            onClickGoogle = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                buildAnnotatedString {
                    append("Already a member? ")
                    withStyle(
                        style = AppTextStyles.smallerTextBold.copy(color = AppColors.secondary100).toSpanStyle()
                    ) {
                        append("Sign In")
                    }
                },
                style = AppTextStyles.smallerTextBold,
                modifier = Modifier.clickable(onClick = {})
            )

        }
    }
}



@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}