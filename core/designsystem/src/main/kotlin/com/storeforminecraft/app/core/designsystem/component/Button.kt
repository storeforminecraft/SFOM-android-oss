package com.storeforminecraft.app.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme


sealed class SFOMButtonSize(
    val horizontal: Dp,
    val vertical: Dp,
    val cornerRadius: Dp,
    val iconSize: Dp,
    val iconAndTextSpacing: Dp,
    val textStyle: @Composable () -> TextStyle
) {
    data object SMALL : SFOMButtonSize(
        horizontal = 12.dp,
        vertical = 6.dp,
        cornerRadius = 12.dp,
        iconSize = 12.dp,
        iconAndTextSpacing = 8.dp,
        textStyle = {
            SFOMTheme.typography.XXS.copy(
                fontWeight = FontWeight.Bold
            )
        })

    data object MD : SFOMButtonSize(
        horizontal = 12.dp,
        vertical = 10.dp,
        cornerRadius = 16.dp,
        iconSize = 16.dp,
        iconAndTextSpacing = 12.dp,
        textStyle = {
            SFOMTheme.typography.XS.copy(
                fontWeight = FontWeight.Bold
            )
        })

    data object LG : SFOMButtonSize(
        horizontal = 12.dp,
        vertical = 12.dp,
        cornerRadius = 24.dp,
        iconSize = 20.dp,
        iconAndTextSpacing = 12.dp,
        textStyle = {
            SFOMTheme.typography.SM.copy(
                fontWeight = FontWeight.Bold
            )
        })

    data object FULLWIDTH : SFOMButtonSize(
        horizontal = 16.dp,
        vertical = 16.dp,
        cornerRadius = 20.dp,
        iconSize = 20.dp,
        iconAndTextSpacing = 12.dp,
        textStyle = {
            SFOMTheme.typography.MD.copy(
                fontWeight = FontWeight.Bold
            )
        })
}

@Preview
@Composable
fun SFOMButtonPreview() {
    SFOMTheme {
        SFOMButton(
            text = "value",
            null,
            null,
            backgroundColor = SFOMTheme.colorScheme.sfomGreenPrimary,
            textColor = SFOMTheme.colorScheme.textWhite,
            sfomButtonSize = SFOMButtonSize.FULLWIDTH
        ) {

        }
    }
}

@Composable
fun SFOMButton(
    text: String?,
    @DrawableRes icon: Int?,
    iconTintColor: Color?,
    backgroundColor: Color,
    textColor: Color?,
    sfomButtonSize: SFOMButtonSize,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier
            .let {
                if (sfomButtonSize is SFOMButtonSize.FULLWIDTH) {
                    it.fillMaxWidth()
                } else {
                    it
                }
            }
            .background(
                color = backgroundColor, shape = RoundedCornerShape(sfomButtonSize.cornerRadius)
            )
            .clip(
                RoundedCornerShape(sfomButtonSize.cornerRadius)
            )
            .clickable {
                onClick()
            }
            .padding(sfomButtonSize.horizontal, sfomButtonSize.vertical),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        icon?.let {
            Image(
                painter = painterResource(icon),
                colorFilter = if (iconTintColor != null) ColorFilter.tint(iconTintColor) else null,
                modifier = Modifier.size(sfomButtonSize.iconSize),
                contentDescription = null
            )
        }

        if (text != null && icon != null) {
            Spacer(Modifier.width(sfomButtonSize.iconAndTextSpacing))
        }

        text?.let {
            Text(
                text = it,
                style = sfomButtonSize.textStyle(),
                color = textColor ?: SFOMTheme.colorScheme.textPrimary
            )
        }
    }
}

@Preview
@Composable
fun TitleWithRightButtonPreview() {
    SFOMTheme {
        TitleWithRightButton(
            "Upload Recently", "My Contents"
        ) { }
    }
}

@Composable
fun TitleWithRightButton(
    title: String, actionText: String, modifier: Modifier = Modifier, onActionTextClick: () -> Unit
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