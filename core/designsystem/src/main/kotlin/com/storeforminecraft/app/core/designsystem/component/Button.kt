package com.storeforminecraft.app.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun TitleWithRightButtonPreview() {
    SFOMTheme {
        TitleWithRightButton(
            "Upload Recently",
            "My Contents"
        ) { }
    }
}

@Composable
fun TitleWithRightButton(
    title: String,
    actionText: String,
    modifier: Modifier = Modifier,
    onActionTextClick: () -> Unit
) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = title, style = SFOMTheme.typography.MD.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        ActionText(actionText, onClick = onActionTextClick)
    }
}