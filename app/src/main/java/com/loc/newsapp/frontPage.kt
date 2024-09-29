package com.loc.newsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrontPage() {
    Scaffold(topBar = {
        TopAppBar(title = { Text("NewsApp") })
    },
        bottomBar = { BottomAppBar {
            Text("Bottom App Bar")
        }}) { padding ->
        Text(text = "This is news app", modifier = Modifier.padding(padding))
    }
}
