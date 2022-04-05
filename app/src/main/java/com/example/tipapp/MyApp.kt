package com.example.tipapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyApp() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(12.dp)) {
        TopHeader()
        MainContent()

    }
}

