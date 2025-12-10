package com.storeforminecraft.app.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun SFOMSelectPreview() {
    SFOMTheme {
        Column(Modifier.fillMaxWidth()) {
            SFOMSelect(
                "Attachment",
                "Select",
                Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = SFOMTheme.colorScheme.outlineSecondary,
                        shape = RoundedCornerShape(16.dp)
                    )
            )

            Spacer(Modifier.height(8.dp))

            SFOMSelect(
                "Attachment",
                "Select",
                Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = SFOMTheme.colorScheme.outlineSecondary,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                SFOMButton(
                    text = "Upload",
                    icon = SFOMIcons.FOLDER,
                    iconTintColor = SFOMTheme.colorScheme.textPrimary,
                    backgroundColor = SFOMTheme.colorScheme.backgroundSecondary,
                    textColor = SFOMTheme.colorScheme.textPrimary,
                    sfomButtonStyle = SFOMButtonStyle.FULLWIDTH
                ) {

                }
            }
        }
    }
}

@Composable
fun SFOMSelect(
    title: String,
    hint: String,
    modifier: Modifier = Modifier,
    value: String? = null,
    childComponent: (@Composable () -> Unit)? = null
) {
    Column(
        modifier
            .padding(16.dp, 12.dp)
    ) {
        Text(
            title, color = SFOMTheme.colorScheme.textTertiary, style = SFOMTheme.typography.SM.copy(
                fontWeight = FontWeight.Normal
            )
        )

        Spacer(Modifier.height(4.dp))

        Text(
            value ?: hint,
            color = if (value != null) SFOMTheme.colorScheme.textPrimary else SFOMTheme.colorScheme.textTertiary,
            style = SFOMTheme.typography.MD.copy(
                fontWeight = FontWeight.Bold
            )
        )

        if (childComponent != null) {
            Spacer(Modifier.height(12.dp))

            childComponent()
        }
    }
}