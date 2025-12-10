package com.storeforminecraft.app.core.designsystem.component

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun OptionButtonPreview() {
    var isSelectedA by remember {
        mutableStateOf(false)
    }

    var isSelectedB by remember {
        mutableStateOf(false)
    }

    SFOMTheme {
        Row(Modifier.fillMaxWidth()) {
            OptionButton(
                modifier = Modifier.fillMaxWidth().weight(1f),
                text = "Text",
                isSelected = isSelectedA
            ) {
                isSelectedA = !isSelectedA
            }

            Spacer(Modifier.width(8.dp))

            OptionButton(
                modifier = Modifier.fillMaxWidth().weight(1f),
                text = "Text",
                isSelected = isSelectedB,
                textSelected = "Selected"
            ) {
                isSelectedB = !isSelectedB
            }
        }
    }
}

@Composable
fun OptionButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    textSelected: String? = null,
    onClick: () -> Unit = {},
) {
    Box(
        modifier
            .background(
                color = if (isSelected) SFOMTheme.colorScheme.sfomBlue100 else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .border(0.5.dp, if(isSelected) SFOMTheme.colorScheme.sfomBlue500 else SFOMTheme.colorScheme.outlineTertiary, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (isSelected) {
                Image(
                    painter = painterResource(SFOMIcons.CHECK),
                    null,
                    Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(SFOMTheme.colorScheme.sfomBlue500)
                )
                Spacer(Modifier.width(12.dp))
            }
            Text(
                modifier = Modifier
                    .defaultMinSize(minHeight = 24.dp)
                    .wrapContentHeight(Alignment.CenterVertically),
                text = if (isSelected) textSelected ?: text else text, style = SFOMTheme.typography.SM.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = if (isSelected) SFOMTheme.colorScheme.sfomBlue500 else SFOMTheme.colorScheme.textPrimary
            )
        }
    }
}