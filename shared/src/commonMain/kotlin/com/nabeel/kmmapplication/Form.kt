package com.nabeel.kmmapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
internal fun Form() {

    var name by remember {
        mutableStateOf("")
    }

    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = {
                    Text(text = "Form", color = Color.Black)
                },
                backgroundColor = Color.Gray,
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn", tint = Color.Black)
                    }
                },
//                backgroundColor = Color.Transparent,
                contentColor = Color.Gray,
                elevation = 2.dp
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = {
                    name = it
                },
                label = { Text("Name") },
            )

            Button(onClick = {
                             name = "clicked by $name"
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Click")
            }
        }
    }
}