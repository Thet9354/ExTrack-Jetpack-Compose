package com.example.goodbyemoney.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.goodbyemoney.components.TableRow
import com.example.goodbyemoney.ui.theme.BackgroundElevated
import com.example.goodbyemoney.ui.theme.Shapes
import com.example.goodbyemoney.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Settings") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(BackgroundElevated)
                        .fillMaxWidth()
                ) {
                    TableRow("Categories", hasArrow = true)
                    TableRow("Erase all data", isDestructive = true)

                }
            }

        }
    )
}