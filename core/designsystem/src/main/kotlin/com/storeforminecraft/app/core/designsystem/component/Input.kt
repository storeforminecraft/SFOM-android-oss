package com.storeforminecraft.app.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun SFOMInputPreview() {
    val textFieldState = rememberTextFieldState()

    SFOMTheme(content = {
        SFOMInput(state = textFieldState, modifier = Modifier.fillMaxWidth(), hint = "Input")
    })
}

@Composable
fun SFOMInput(state: TextFieldState, modifier: Modifier = Modifier, hint: String? = null) {
    BasicTextField(
        modifier = modifier
            .border(0.5.dp, SFOMTheme.colorScheme.outlineSecondary, RoundedCornerShape(16.dp))
            .padding(16.dp),
        state = state,
        textStyle = SFOMTheme.typography.MD,
        decorator = { innerTextField ->
            if (state.text.isEmpty() && hint != null) {
                Text(
                    text = hint,
                    style = SFOMTheme.typography.MD.copy(
                        color = SFOMTheme.colorScheme.textTertiary
                    )
                )
            }
            innerTextField()
        }
    )
}