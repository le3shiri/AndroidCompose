package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Use MaterialTheme direct si ma3andkch HelloCounterTheme
            MaterialTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DireBonjourSection()
        CompteurSection()
    }
}

@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var greetingName by rememberSaveable { mutableStateOf<String?>(null) }

    Column(modifier = modifier.fillMaxWidth()) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Prénom") },
            placeholder = { Text("Entre ton prénom") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { greetingName = name.takeIf { it.isNotBlank() } },
            enabled = name.isNotBlank(),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Dire Bonjour")
        }

        if (greetingName != null) {
            AssistChip(
                onClick = { /* nothing */ },
                label = { Text("Bonjour $greetingName") },
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun CompteurSection(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        IconButton(onClick = { if (count > 0) count-- }) {
            Icon(imageVector = Icons.Filled.Remove, contentDescription = "Diminuer")
        }
        Text(
            text = "$count",
            style = MaterialTheme.typography.headlineSmall
        )
        IconButton(onClick = { count++ }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Augmenter")
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun PreviewMainScreen() {
    MaterialTheme {
        Surface {
            MainScreen()
        }
    }
}
