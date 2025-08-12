package com.storeforminecraft.app.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun ActionTextPreview() {
    SFOMTheme {
        ActionText("My Contents") {

        }
    }
}

@Composable
fun ActionText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = SFOMTheme.colorScheme.sfomGreenPrimary,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = SFOMTheme.typography.XS.copy(fontWeight = FontWeight.Bold),
            color = color
        )

        Spacer(Modifier.width(4.dp))

        Image(
            colorFilter = ColorFilter.tint(color = SFOMTheme.colorScheme.sfomGreenPrimary),
            modifier = Modifier.size(16.dp),
            painter = painterResource(SFOMIcons.CHEVRON_RIGHT),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun TagStyleTextPreview() {
    SFOMTheme {
        TagStyleText(
            "Account",
            SFOMIcons.ACCOUNT_CIRCLE,
            SFOMTheme.colorScheme.backgroundSecondary,
            SFOMTheme.colorScheme.textPrimary,
            SFOMTheme.colorScheme.colorsExclamation
        )
    }
}

@Composable
fun TagStyleText(
    text: String,
    @DrawableRes icon: Int?,
    backgroundColor: Color,
    textColor: Color,
    iconColor: Color
) {
    Row(
        Modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(20.dp))
            .padding(8.dp, 4.dp)
    ) {
        Text(
            text = text,
            color = SFOMTheme.colorScheme.textPrimary,
            style = SFOMTheme.typography.XS.copy(
                fontWeight = FontWeight.SemiBold
            )
        )

        if (icon != null) {
            Spacer(Modifier.width(4.dp))

            Image(
                painterResource(icon),
                null,
                modifier = Modifier.size(14.dp),
                colorFilter = ColorFilter.tint(iconColor)
            )
        }
    }
}