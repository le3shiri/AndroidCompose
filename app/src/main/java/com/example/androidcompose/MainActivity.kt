// Package name: Had l'package kay7dd l'namespace dyal l'app
package com.example.androidcompose

// Imports: Kayjib les classes w libraries li khassna
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

// Class principale: MainActivity huwa l'entry point dyal l'app Android
class MainActivity : ComponentActivity() {
    // Function onCreate: Kaytcall wha l'app tlaunch, bach tset l'UI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Theme: Sta3mel MaterialTheme bach ydir colors w styles dyal Material Design
            // Comment: Use MaterialTheme direct si ma3andkch HelloCounterTheme custom
            MaterialTheme {
                // Surface: Container bach ydir background clean
                Surface {
                    // Call l'screen principale
                    MainScreen()
                }
            }
        }
    }
}

// Composable function: MainScreen huwa l'UI principale, kaydir column m3a juj sections
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // Column: Vertical layout bach ystack les elements
    Column(
        modifier = modifier
            .fillMaxSize() // Fill l'screen kaml
            .padding(16.dp), // Padding mn kul jenb 16dp
        verticalArrangement = Arrangement.spacedBy(24.dp), // Space bin elements 24dp
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        // Call sections
        DireBonjourSection()
        CompteurSection()
    }
}

// Composable function: Section bach tktb smiytek w t'affichi greeting
@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    // States: rememberSaveable bach y7fD l'data across rotations w configurations
    var name by rememberSaveable { mutableStateOf("") } // State dyal l'name input
    var greetingName by rememberSaveable { mutableStateOf<String?>(null) } // State dyal l'greeting, initial null

    // Column: Vertical stack, fill width
    Column(modifier = modifier.fillMaxWidth()) {

        // TextField: Input bach tktb smiytek
        OutlinedTextField(
            value = name, // Value mn state
            onValueChange = { name = it }, // Update state wha tktb
            label = { Text("Prénom") }, // Label
            placeholder = { Text("Entre ton prénom") }, // Placeholder
            singleLine = true, // Single line
            modifier = Modifier.fillMaxWidth() // Fill width
        )

        // Button: Bach tcliki w tset greeting
        Button(
            onClick = { greetingName = name.takeIf { it.isNotBlank() } }, // Set greeting law name mhach blank
            enabled = name.isNotBlank(), // Enabled law name not blank
            modifier = Modifier.padding(top = 8.dp) // Padding top
        ) {
            Text("Dire Bonjour") // Text dyal button
        }

        // Conditional: Law greetingName not null, affich chip
        if (greetingName != null) {
            AssistChip(
                onClick = { /* nothing */ }, // No action on click
                label = { Text("Bonjour $greetingName") }, // Text m3a name
                modifier = Modifier.padding(top = 8.dp) // Padding top
            )
        }
    }
}

// Composable function: Section dyal counter m3a + w -
@Composable
fun CompteurSection(modifier: Modifier = Modifier) {
    // State: rememberSaveable bach y7fD l'count
    var count by rememberSaveable { mutableStateOf(0) } // Initial 0

    // Row: Horizontal layout bach yalign elements
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically, // Center vertically
        horizontalArrangement = Arrangement.spacedBy(12.dp) // Space bin elements 12dp
    ) {
        // IconButton -: N9s count law >0
        IconButton(onClick = { if (count > 0) count-- }) {
            Icon(imageVector = Icons.Filled.Remove, contentDescription = "Diminuer") // Icon w description
        }
        // Text: Affich count
        Text(
            text = "$count", // Convert to string
            style = MaterialTheme.typography.headlineSmall // Style headline small
        )
        // IconButton +: Zid count
        IconButton(onClick = { count++ }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Augmenter") // Icon w description
        }
    }
}

// Preview: Bach tshof l'UI f Android Studio bla run l'app
@Preview(showBackground = true, widthDp = 360)
@Composable
fun PreviewMainScreen() {
    // Wrap f theme w surface bach ykoun realistic
    MaterialTheme {
        Surface {
            MainScreen()
        }
    }
}