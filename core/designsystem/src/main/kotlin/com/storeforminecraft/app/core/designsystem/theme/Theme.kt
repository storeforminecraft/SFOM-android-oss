package com.storeforminecraft.app.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalSFOMColorScheme = staticCompositionLocalOf {
    LightSFOMColorScheme
}

private val LocalSFOMTypography = staticCompositionLocalOf {
    DefaultSFOMTypography
}

@Composable
fun SFOMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSFOMTypography provides DefaultSFOMTypography,
        LocalSFOMColorScheme provides if (darkTheme) DarkSFOMColorScheme else LightSFOMColorScheme
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object SFOMTheme {
    val typography: SFOMTypography
        @Composable
        get() = LocalSFOMTypography.current
    val colorScheme: SFOMColorScheme
        @Composable
        get() = LocalSFOMColorScheme.current
}