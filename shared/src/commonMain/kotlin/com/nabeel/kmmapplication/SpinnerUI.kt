package com.nabeel.studentdatacollection.widgets

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpinnerUI(): String {
    val options = listOf("Class 1","Class 2","Class 3","Class 4","Class 5","Class 6","Class 7","Class 8")
    var expendedState by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }
    val mContext = LocalContext.current

    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expendedState,
        onExpandedChange = {expendedState = !expendedState}
    ) {
        TextField(
            value = selectedOption,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {},
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expendedState)},
            readOnly = true,
            textStyle = TextStyle.Default.copy(fontSize = 18.sp)
        )

        ExposedDropdownMenu(
            modifier = Modifier.fillMaxHeight(0.25f),
            expanded = expendedState,
            onDismissRequest = { expendedState = false }

        ) {
            options.forEach{
                eachOption -> DropdownMenuItem(onClick = {
                    selectedOption = eachOption
                    expendedState = false
                    Toast.makeText(mContext, selectedOption, Toast.LENGTH_SHORT).show()
            }) {
                    Text(text = eachOption, fontSize = 18.sp)
            }
            }
        }
    }
    return selectedOption
}