package com.nabeel.kmmapplication

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

class AndroidToastHelper(private val context: Context): ToastHelper {
    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}