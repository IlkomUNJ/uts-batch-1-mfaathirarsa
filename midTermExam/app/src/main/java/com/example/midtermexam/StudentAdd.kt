package com.example.midtermexam

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudentScreen(
    onStudentAdded: () -> Unit,
    onToggleTheme: () -> Unit,
    darkTheme: Boolean
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Student") },
                navigationIcon = {
                    IconButton(onClick = onStudentAdded) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(
                            imageVector = if (darkTheme) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var id by remember { mutableStateOf("") }
            var name by remember { mutableStateOf("") }
            var phone by remember { mutableStateOf("") }
            var address by remember { mutableStateOf("") }

            OutlinedTextField(value = id, onValueChange = { id = it }, label = { Text("ID") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = address, onValueChange = { address = it }, label = { Text("Address") })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (id.isNotBlank() && name.isNotBlank()) {
                    Student.studentList.add(Student(id, name, phone, address))
                    onStudentAdded()
                }
            }) {
                Text("Save Student")
            }
        }
    }
}
