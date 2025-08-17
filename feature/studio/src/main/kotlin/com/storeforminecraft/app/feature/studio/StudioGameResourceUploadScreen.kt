package com.storeforminecraft.app.feature.studio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMColorScheme
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme


@Preview
@Composable
fun StudioGameResourceUploadScreenPreview() {
    SFOMTheme {
        StudioGameResourceUploadScreen()
    }
}

@Composable
fun StudioGameResourceUploadScreen() {
    Column(Modifier.fillMaxSize()) {
        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = {

            }
        ) {
            Icon(
                painter = painterResource(SFOMIcons.CLOSE),
                contentDescription = null,
                tint = SFOMTheme.colorScheme.textQuaternary
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Let's Upload\nNew Contents",
            style = SFOMTheme.typography.XL.copy(fontWeight = FontWeight.Bold),
            color = SFOMTheme.colorScheme.textPrimary
        )

        Spacer(Modifier.height(24.dp))
    }
}