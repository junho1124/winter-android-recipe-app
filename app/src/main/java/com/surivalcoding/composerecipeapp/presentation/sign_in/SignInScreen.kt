package com.surivalcoding.composerecipeapp.presentation.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.base.ShadowBox
import com.surivalcoding.composerecipeapp.presentation.component.base.TextInputField
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = AppColors.white)
                .padding(horizontal = 30.dp, vertical = 50.dp)
        ) {
            Text("Hello,", style = AppTextStyles.headerTextBold)
            Text("Welcome Back!", style = AppTextStyles.largeTextRegular)
            Spacer(modifier = Modifier.height(57.dp))
            TextInputField(label = "Email", hint = "Enter email", onValueChange = {})
            Spacer(modifier = Modifier.height(30.dp))
            TextInputField(label = "Enter Password", hint = "Enter Password", visualTransformation = PasswordVisualTransformation(), onValueChange = {})
            Text(
                "Forgot Password?",
                style = AppTextStyles.smallerTextRegular.copy(color = AppColors.secondary100),
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp, bottom = 25.dp)
                    .clickable(onClick = {})
            )
            BigButton(text = "Sign In", onClick = {})
            Spacer(modifier = Modifier.height(20.dp))
            OrSignInWith(
                onClickFacebook = {},
                onClickGoogle = {}
            )
            Spacer(modifier = Modifier.height(55.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    buildAnnotatedString {
                        append("Don't have an account? ")
                        withStyle(
                            style = AppTextStyles.smallerTextBold.copy(color = AppColors.secondary100).toSpanStyle()
                        ) {
                            append("Sign Up")
                        }
                    },
                    style = AppTextStyles.smallerTextBold,
                    modifier = Modifier.clickable(onClick = {})
                )

            }
        }

}


@Composable
fun OrSignInWith(modifier: Modifier = Modifier, onClickFacebook: () -> Unit = {}, onClickGoogle: () -> Unit = {}) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            HorizontalDivider(
                modifier = Modifier.width(50.dp),
                color = AppColors.gray4,
                thickness = DividerDefaults.Thickness
            )
            Text(
                "Or Sign In With",
                style = AppTextStyles.smallerTextRegular.copy(
                    color = AppColors.gray4,
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier.padding(horizontal = 7.dp)
            )
            HorizontalDivider(
                modifier = Modifier.width(50.dp),
                color = AppColors.gray4,
                thickness = DividerDefaults.Thickness
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            ShadowBox(
                modifier = Modifier.size(44.dp),
                onClick = onClickGoogle
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Google",
                    painter = painterResource(id = R.drawable.ic_google)
                )
            }
            Spacer(modifier = Modifier.width(25.dp))
            ShadowBox(
                modifier = Modifier.size(44.dp),
                onClick = onClickFacebook
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    contentDescription = "facebook",
                    painter = painterResource(id = R.drawable.ic_facebook)
                )
            }
        }
    }
}


@Preview
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}