package com.example.goodbyemoney.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(

    primary = Primary,

    background = Surface,

    surface = Surface,

    onPrimary = TextPrimary,

    onSecondary = TextPrimary,

    onBackground = TextPrimary,

    onSurface = TextPrimary,

    error = Destructive,

)

@Composable
fun GoodbyeMoneyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val colors = DarkColorPalette

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}