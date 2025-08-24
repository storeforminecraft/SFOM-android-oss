package com.storeforminecraft.app.core.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview(showBackground = true)
@Composable
fun SFOMCheckboxPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        var isChecked1 by remember { mutableStateOf(true) }
        var isChecked2 by remember { mutableStateOf(false) }

        SFOMCheckbox(
            isChecked = isChecked1,
        ) {
            isChecked1 = !isChecked1
        }

        SFOMCheckbox(
            isChecked = isChecked2
        ) {
            isChecked2 = !isChecked2
        }
    }
}

@Composable
fun SFOMCheckbox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp,
    onClick: () -> Unit
) {
    val borderColor by animateColorAsState(
        targetValue = if (isChecked) SFOMTheme.colorScheme.sfomGreenPrimary else SFOMTheme.colorScheme.backgroundQuaternary,
        animationSpec = tween(durationMillis = 200),
        label = "borderColorAnimation"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isChecked) SFOMTheme.colorScheme.sfomGreenPrimary else Color.Transparent,
        animationSpec = tween(durationMillis = 200),
        label = "backgroundColorAnimation"
    )

    val checkScale by animateFloatAsState(
        targetValue = if (isChecked) 1f else 0f,
        animationSpec = tween(durationMillis = 200),
        label = "checkScaleAnimation"
    )

    Box(
        modifier = modifier
            .size(size)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(2.dp)
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(2.dp)
            )
            .clip(
                RoundedCornerShape(2.dp)
            )
            .clickable(
                onClick = {
                    onClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(SFOMIcons.CHECK_SMALL),
            contentDescription = null,
            modifier = Modifier
                .scale(checkScale)
                .graphicsLayer {
                    blendMode = BlendMode.DstOut
                }
        )
    }
}