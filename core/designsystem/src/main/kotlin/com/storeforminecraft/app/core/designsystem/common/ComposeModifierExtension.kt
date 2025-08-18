package com.storeforminecraft.app.core.designsystem.common

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

fun Modifier.dottedBorder(
    strokeWidth: Dp,
    color: Color,
    dotLength: Float,
    gapLength: Float,
    cornerRadius: Dp
): Modifier = this.then(
    Modifier
        .padding(strokeWidth)
        .drawBehind {
            val pathEffect = PathEffect.dashPathEffect(floatArrayOf(dotLength, gapLength), 0f)
            val stroke = Stroke(width = strokeWidth.toPx(), pathEffect = pathEffect)
            drawRoundRect(
                color = color,
                size = size,
                style = stroke,
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadius.toPx())
            )
        })