package com.example.goodbyemoney.pages

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodbyemoney.components.ReportPage
import com.example.goodbyemoney.models.Recurrence
import com.example.goodbyemoney.ui.theme.TopAppBarBackground
import com.example.goodbyemoney.viewmodels.ReportsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun Reports(vm: ReportsViewModel = viewModel()) {
    val uiState = vm.uiState.collectAsState().value

    val recurrences = listOf(
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly
    )

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Reports") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                ),
                actions = {
                    IconButton(onClick = vm::openRecurrenceMenu) {
                        Icon(
                            painterResource(id = com.example.goodbyemoney.R.drawable.ic_today),
                            contentDescription = "Change recurrence"
                        )
                    }
                    DropdownMenu(
                        expanded = uiState.recurrenceMenuOpened,
                        onDismissRequest = vm::closeRecurrenceMenu
                    ) {
                        recurrences.forEach { recurrence ->
                            DropdownMenuItem(text = { Text(recurrence.name) }, onClick = {
                                vm.setRecurrence(recurrence)
                                vm.closeRecurrenceMenu()
                            })
                        }
                    }
                }
            )
        },
        content = { innerPadding ->
            val numOfPages = when (uiState.recurrence) {
                Recurrence.Weekly -> 53
                Recurrence.Monthly -> 12
                Recurrence.Yearly -> 1
                else -> 53
            }
            HorizontalPager(count = numOfPages, reverseLayout = true) { page ->
                ReportPage(innerPadding, page, uiState.recurrence)
            }
        }
    )
}