package com.example.androidcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LayoutsThemesSimpleDemo() {
    // Column = layout vertikal (mn fo9 lta7t)
    Column(
        modifier = Modifier
            .fillMaxSize() // ya5od kol l'écran
            .padding(24.dp), // space mn l7waf
        verticalArrangement = Arrangement.spacedBy(24.dp), // space bin l3nasir
        horizontalAlignment = Alignment.CenterHorizontally // kolchi f center
    ) {
        GreetingSection()
        CounterSection()
        AvatarBox()
    }
}

@Composable
fun GreetingSection() {
    // state bach nkhdmo 3la smiya
    var name by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Smitk:",
            style = MaterialTheme.typography.titleMedium
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ktob smitk hna") }
        )

        // Text kaybdel 7asb smit li ktb l user
        if (name.isNotEmpty()) {
            Text(
                text = "Salam $name 👋",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun CounterSection() {
    var count by remember { mutableStateOf(0) }

    // Row = layout afqi (mn lisar l limn)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly, // espace equal bin l3nasir
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Button - na9s
        Button(onClick = { if (count > 0) count-- }) {
            Text("-")
        }

        // Text dyal count
        Text(
            text = "$count",
            style = MaterialTheme.typography.headlineSmall
        )

        // Button - zid
        Button(onClick = { count++ }) {
            Text("+")
        }
    }
}

@Composable
fun AvatarBox() {
    // Box = layering layout (wa7ed fo9 wa7ed)
    Box(
        modifier = Modifier
            .size(100.dp) // taille dyal box
            .background(Color.LightGray, shape = CircleShape), // sora gray b circle
        contentAlignment = Alignment.BottomEnd // badge f coin ta7t limn
    ) {
        // badge 7mer f coin
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(MaterialTheme.colorScheme.error, shape = CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayoutsThemesSimpleDemo() {
    // Theme basique (Material 3)
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF1976D2),
            secondary = Color(0xFF42A5F5),
            error = Color(0xFFD32F2F)
        )
    ) {
        LayoutsThemesSimpleDemo()
    }
}
