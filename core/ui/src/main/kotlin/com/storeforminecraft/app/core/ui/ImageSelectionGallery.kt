package com.storeforminecraft.app.core.ui

import android.net.Uri
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.common.dottedBorder
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme

@Preview
@Composable
fun ImageSelectionGalleryPreview() {
    SFOMTheme {
        ImageSelectionGallery()
    }
}

@Composable
fun ImageSelectionGallery(
    modifier: Modifier = Modifier,
    selectedImageUris: List<Uri> = emptyList()
) {
    LazyRow(modifier, contentPadding = PaddingValues(16.dp, 0.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            ImageSelectButton(Modifier.size(144.dp, 96.dp)) {

            }
        }

        items(items = selectedImageUris, key = { it.toString() }) { uri ->
            SFOMImage(
                uri, Modifier
                    .size(144.dp, 96.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Preview
@Composable
fun ImageSelectButtonPreview() {
    SFOMTheme {
        ImageSelectButton(Modifier.size(144.dp, 96.dp)) {

        }
    }
}

@Composable
fun ImageSelectButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .dottedBorder(
                strokeWidth = 1.dp,
                color = SFOMTheme.colorScheme.outlineTertiary,
                dotLength = 16f,
                gapLength = 4f,
                cornerRadius = 16.dp
            )
            .background(
                color = SFOMTheme.colorScheme.backgroundSecondary,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(
                RoundedCornerShape(16.dp)
            )
            .clickable {
                onClick()
            }
    ) {
        Image(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            painter = painterResource(id = SFOMIcons.PHOTO),
            contentDescription = null,
            colorFilter = ColorFilter.tint(SFOMTheme.colorScheme.textTertiary)
        )
    }
}