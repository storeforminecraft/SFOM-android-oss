package com.storeforminecraft.app.feature.auth

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.component.SFOMButton
import com.storeforminecraft.app.core.designsystem.component.SFOMButtonStyle
import com.storeforminecraft.app.core.designsystem.component.SFOMInput
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview(name = "Email Step")
@Composable
fun SignInScreenEmailStepPreview() {
    SFOMTheme {
        SignInScreen()
    }
}

@Preview(name = "Password Step")
@Composable
fun SignInScreenPasswordStepPreview() {
    SFOMTheme {
        SignInScreen(isPasswordStep = true)
    }
}

@Composable
fun SignInScreen(isPasswordStep: Boolean = false) {
    var isPasswordStepState by remember {
        mutableStateOf(isPasswordStep)
    }
    val emailTextFieldState = rememberTextFieldState()
    val passwordTextFieldState = rememberTextFieldState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            Modifier
                .weight(1f)
                .padding(4.dp)
                .fillMaxSize()
        ) {

            Spacer(Modifier.height(12.dp))

            IconButton(modifier = Modifier.size(24.dp), onClick = {}) {
                Icon(
                    painter = painterResource(com.storeforminecraft.app.core.designsystem.R.drawable.close),
                    null
                )
            }

            Spacer(Modifier.height(32.dp))

            Text(
                if (isPasswordStepState) "돌아오신 것을 환영해요!\n비밀번호를 입력해주세요." else "SFOM 로그인 혹은 가입을 위해\n이메일을 입력해주세요.",
                style = SFOMTheme.typography.XL.copy(
                    color = SFOMTheme.colorScheme.textPrimary,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(Modifier.height(24.dp))

            SFOMInput(
                state = emailTextFieldState,
                hint = "Email",
                modifier = Modifier.fillMaxWidth()
            )

            if (isPasswordStepState) {
                Spacer(Modifier.height(12.dp))
                SFOMInput(
                    state = passwordTextFieldState,
                    hint = "Password",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = if (isPasswordStepState) "비밀번호를 잊어버리셨나요?" else "가입한 이메일을 잊어버리셨나요?",
                style = SFOMTheme.typography.SM.copy(
                    color = SFOMTheme.colorScheme.textSecondary,
                    textDecoration = TextDecoration.Underline
                )
            )
        }

        SFOMButton(
            text = if (isPasswordStepState) "로그인" else "다음",
            backgroundColor = SFOMTheme.colorScheme.sfomGreenPrimary,
            textColor = SFOMTheme.colorScheme.textWhite,
            sfomButtonStyle = SFOMButtonStyle.FULLWIDTH
        ) {
            val email = emailTextFieldState.text.toString()
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && !isPasswordStepState) {
                isPasswordStepState = true
            }
        }
    }
}
