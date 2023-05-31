package com.nabeel.kmmapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nabeel.studentdatacollection.widgets.CheckBoxUI
import com.nabeel.studentdatacollection.widgets.RadioButtonUi
import com.nabeel.studentdatacollection.widgets.SpacerUI
import com.nabeel.studentdatacollection.widgets.SpinnerUI
import kotlinx.coroutines.launch

@Composable
internal fun Form() {

    val scaffoldState = rememberScaffoldState()
//    val mContext = LocalContext.current
    val scope = rememberCoroutineScope()
    var name by remember {
        mutableStateOf("")
    }

    Scaffold {
        Column() {
            TopAppBar(title = {
                Text(text = "Form", color = Color.White, textAlign = TextAlign.Center)
            }, modifier = Modifier.align(CenterHorizontally),
                backgroundColor = Color.Red,
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Menu Btn", tint = Color.White)
                    }
                },
//                backgroundColor = Color.Transparent,
                contentColor = Color.Gray,
                elevation = 2.dp)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = name,
                    label = {
                        Text(text = "Name")
                    },
                    onValueChange = {
                        name = it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                SpacerUI()
                Text(text = "Gender")
                SpacerUI()
                val gender = RadioButtonUi(scaffoldState)
                SpacerUI()
                Text(text = "Class")
                SpacerUI()
                val inClass = SpinnerUI()
                SpacerUI()
                Text(text = "Subjects")
                SpacerUI()
                val subjects = CheckBoxUI(scaffoldState = scaffoldState)
                SpacerUI()
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Clicked")
//                                Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show()
                            }
                        }
                    ){
                        Text("Click")
                    }
//                    Button(
//                        modifier = Modifier.padding(8.dp),
//                        onClick = {
//                                val mssg = "Add Successfully"
////                                Toast.makeText(mContext, mssg, Toast.LENGTH_LONG).show()
////                                navController.popBackStack()
//                            }
//                        }) {
//                        Text(text = "Submit")
//                    }
                }
            }
        }
    }
}


//Column(modifier = Modifier.fillMaxSize()) {
//    TopAppBar(
//        title = {
//            Text(text = "Form", color = Color.Black)
//        },
//        backgroundColor = Color.Gray,
//        navigationIcon = {
//            IconButton(onClick = { }) {
//                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn", tint = Color.Black)
//            }
//        },
////                backgroundColor = Color.Transparent,
//        contentColor = Color.Gray,
//        elevation = 2.dp
//    )
//    Spacer(modifier = Modifier.height(8.dp))
//    TextField(
//        modifier = Modifier.fillMaxWidth(),
//        value = name,
//        onValueChange = {
//            name = it
//        },
//        label = { Text("Name") },
//    )
//
//    Button(onClick = {
//        name = "clicked by $name"
//    }, modifier = Modifier.fillMaxWidth()) {
//        Text("Click")
//    }
//}