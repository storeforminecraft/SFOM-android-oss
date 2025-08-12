package com.storeforminecraft.app.feature.studio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.component.TitleWithRightButton
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme
import java.time.LocalDateTime

@Preview
@Composable
fun StudioScreenPreview() {
    SFOMTheme {
        StudioScreen()
    }
}

@Composable
fun StudioScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        StudioTopBar()
        Spacer(Modifier.height(32.dp))
        TitleWithRightButton(
            title = "Upload Recently",
            actionText = "My Contents",
        ) {

        }
        LazyColumn(contentPadding = PaddingValues(0.dp, 16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(5) {
                StudioResourceItem(Modifier, "제목", LocalDateTime.now(), 50, 50)
            }
        }
    }
}