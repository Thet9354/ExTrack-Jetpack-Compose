package com.example.goodbyemoney.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.goodbyemoney.models.Expense
import com.example.goodbyemoney.ui.theme.LabelSecondary
import com.example.goodbyemoney.ui.theme.Typography
import java.text.DecimalFormat
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpenseRow(expense: Expense, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                expense.note,
                style = Typography.headlineMedium
            )
            Text(
                "USD ${DecimalFormat("0.#").format(expense.amount)}",
                style = Typography.headlineMedium
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryBadge(category = expense.category!!)
            Text(
                expense.date.format(DateTimeFormatter.ofPattern("HH:mm")),
                style = Typography.bodyMedium,
                color = LabelSecondary
            )
        }
    }
}