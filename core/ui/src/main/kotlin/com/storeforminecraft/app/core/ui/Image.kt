package com.storeforminecraft.app.core.ui

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun SFOMImage(uri: Uri, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier,
        model = uri,
        contentDescription = null,
    )
}