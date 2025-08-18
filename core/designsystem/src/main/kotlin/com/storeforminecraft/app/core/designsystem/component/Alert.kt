package com.storeforminecraft.app.core.designsystem.component

import android.view.RoundedCorner
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.storeforminecraft.app.core.designsystem.R
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun AlertMessagePreview() {
    SFOMTheme {
        AlertMessage(
            SFOMIcons.INFO,
            SFOMTheme.colorScheme.sfomBluePrimary,
            "Choose at least two screenshots that clearly show the features of your map.",
            SFOMTheme.colorScheme.textPrimary,
            SFOMTheme.colorScheme.sfomBlue100,
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AlertMessage(
    @DrawableRes icon: Int,
    iconTintColor: Color,
    message: String,
    messageTextColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(color = backgroundColor, RoundedCornerShape(10.dp))
            .padding(16.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(icon),
            modifier = Modifier.size(20.dp),
            contentDescription = null,
            colorFilter = ColorFilter.tint(iconTintColor)
        )

        Spacer(Modifier.width(16.dp))

        Text(
            text = message, color = messageTextColor, style = SFOMTheme.typography.XS.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}