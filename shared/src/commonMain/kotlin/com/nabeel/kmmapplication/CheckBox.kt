package com.nabeel.studentdatacollection.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CheckBoxUI(scaffoldState: ScaffoldState): String {
    val genderList by remember {
        mutableStateOf(listOf("Hindi","English","Maths","Science"))
    }
    val scope = rememberCoroutineScope()
    val subjectList = remember {
        mutableListOf<String>()
    }

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,

//        verticalArrangement = Arrangement.Center
    ) {
        genderList.forEach { checkboxValue ->
            var selectedState by remember {
                mutableStateOf(false)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
//                horizontalArrangement = Arrangement.Start,
//                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedState,
                    onCheckedChange = {
                        selectedState = it
                        if (it) subjectList.add(checkboxValue) else subjectList.remove(checkboxValue)
                    })
                Text(text = checkboxValue, modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
    return subjectList.toString()
}

//RadioButton(
//modifier = Modifier.background(color = Color.Red).padding(0.dp),
//selected = genderState == it,
//onClick = {
//    genderState = it
//    scope.launch {
//        scaffoldState.snackbarHostState.showSnackbar(genderState)
//    }
//},
//colors = RadioButtonDefaults.colors(
//selectedColor = Color.Green
//)
//)