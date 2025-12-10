package com.storeforminecraft.app.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.storeforminecraft.app.core.designsystem.R
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

sealed class SFOMLabelInputStyle(
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val spaceBetweenLabelAndText: Dp,
    val labelTextStyle: @Composable () -> TextStyle,
    val textStyle: @Composable () -> TextStyle,
    val iconSize: Dp
) {
    data object Regular : SFOMLabelInputStyle(
        horizontalPadding = 16.dp,
        verticalPadding = 12.dp,
        spaceBetweenLabelAndText = 4.dp,
        labelTextStyle = {
            SFOMTheme.typography.SM.copy(
                color = SFOMTheme.colorScheme.textTertiary
            )
        },
        textStyle = {
            SFOMTheme.typography.MD.copy(
                color = SFOMTheme.colorScheme.textPrimary
            )
        },
        iconSize = 16.dp
    )

    data object Small : SFOMLabelInputStyle(
        horizontalPadding = 12.dp,
        verticalPadding = 8.dp,
        spaceBetweenLabelAndText = 4.dp,
        labelTextStyle = {
            SFOMTheme.typography.XXS.copy(
                color = SFOMTheme.colorScheme.textTertiary
            )
        },
        textStyle = {
            SFOMTheme.typography.XS.copy(
                color = SFOMTheme.colorScheme.textPrimary
            )
        },
        iconSize = 16.dp
    )
}

@Composable
fun SFOMLabelInput(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    hint: String,
    label: String,
    style: SFOMLabelInputStyle,
    @DrawableRes icon: Int? = null,
    iconTint: Color? = null,
    iconClickAction: (() -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isHintUp = isFocused || state.text.isNotEmpty()

    val labelTextStyle = style.labelTextStyle()
    val textStyle = style.textStyle()

    val density = LocalDensity.current

    val labelHeightPx = with(density) { labelTextStyle.fontSize.toPx() }
    val spaceBetweenPx = with(density) { style.spaceBetweenLabelAndText.toPx() }

    val translateYValue = (labelHeightPx + spaceBetweenPx) / 2f

    val animatedTranslateY by animateFloatAsState(
        targetValue = if (isHintUp) 0f else translateYValue,
        label = "hintTranslateY"
    )

    val animatedFontSize by animateFloatAsState(
        targetValue = if (isHintUp) labelTextStyle.fontSize.value else textStyle.fontSize.value,
        label = "hintFontSize"
    )

    Box(
        modifier = modifier
            .border(0.5.dp, Color.LightGray, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = style.horizontalPadding,
                    vertical = style.verticalPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = label,
                    style = labelTextStyle,
                    color = Color.Transparent,
                )
                Spacer(Modifier.height(style.spaceBetweenLabelAndText))
                BasicTextField(
                    state = state,
                    textStyle = textStyle,
                    interactionSource = interactionSource,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            icon?.let {
                IconButton(
                    modifier = Modifier.size(style.iconSize),
                    onClick = iconClickAction ?: {}) {
                    Icon(
                        painter = painterResource(it),
                        contentDescription = null,
                        tint = iconTint ?: SFOMTheme.colorScheme.textPrimary,
                    )
                }
            }
        }

        Text(
            text = if (isHintUp) label else hint,
            color = labelTextStyle.color,
            style = textStyle.copy(fontSize = animatedFontSize.sp),
            modifier = Modifier
                .padding(
                    horizontal = style.horizontalPadding,
                    vertical = style.verticalPadding
                )
                .graphicsLayer {
                    translationY = animatedTranslateY
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SFOMLabelInputPreview() {
    val emptyTextFieldState = rememberTextFieldState("")
    val fillTextFieldState = rememberTextFieldState("filled")

    SFOMTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            SFOMLabelInput(
                state = emptyTextFieldState,
                modifier = Modifier.fillMaxWidth(),
                hint = "please fill",
                label = "Input (Regular)",
                style = SFOMLabelInputStyle.Regular
            )

            Spacer(Modifier.height(16.dp))

            SFOMLabelInput(
                state = fillTextFieldState,
                modifier = Modifier.fillMaxWidth(),
                hint = "please fill",
                label = "Input (Regular)",
                style = SFOMLabelInputStyle.Regular
            )

            Spacer(Modifier.height(16.dp))

            SFOMLabelInput(
                state = emptyTextFieldState,
                modifier = Modifier.fillMaxWidth(),
                hint = "please fill",
                label = "Input (Small)",
                style = SFOMLabelInputStyle.Small,
                icon = SFOMIcons.MINUS_CIRCLE
            )

            Spacer(Modifier.height(16.dp))

            SFOMLabelInput(
                state = fillTextFieldState,
                modifier = Modifier.fillMaxWidth(),
                hint = "please fill",
                label = "Input (Small)",
                style = SFOMLabelInputStyle.Small
            )
        }
    }
}