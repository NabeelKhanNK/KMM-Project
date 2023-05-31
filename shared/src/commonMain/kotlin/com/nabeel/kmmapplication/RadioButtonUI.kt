package com.nabeel.studentdatacollection.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun RadioButtonUi(scaffoldState: ScaffoldState): String
{

    val genderList by remember {
        mutableStateOf(listOf("Male","Female","Other"))
    }
    var genderState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,

//        verticalArrangement = Arrangement.Center
    ) {
        genderList.forEach {
            Row(modifier = Modifier
                .fillMaxWidth()
//                horizontalArrangement = Arrangement.Start,
//                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier.padding(0.dp),
                    selected = genderState == it,
                    onClick = {
                        genderState = it
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(genderState)
                        }
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green
                    )
                )
                Text(text = it, modifier = Modifier.align(CenterVertically))
            }
        }
    }
    return genderState
}