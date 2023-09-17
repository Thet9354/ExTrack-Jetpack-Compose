package com.example.goodbyemoney.components

import android.provider.CalendarContract.Colors
import android.widget.TableRow
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.goodbyemoney.R
import com.example.goodbyemoney.ui.theme.Destructive
import com.example.goodbyemoney.ui.theme.TextPrimary
import com.example.goodbyemoney.ui.theme.Typography

@Composable
fun TableRow(label: String, hasArrow: Boolean = false, isDestructive: Boolean = false) {

    val textColor = if (isDestructive == true) Destructive else TextPrimary

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = Typography.bodyMedium, color = textColor)
        if (hasArrow) {
            Icon(
                painterResource(id = R.drawable.chevron_right),
                contentDescription = "Right Arrow"
            )
        }

    }
}