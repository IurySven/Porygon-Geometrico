package com.example.poregon_poligonal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.porygongeometrico.R
import com.example.porygongeometrico.ui.theme.PorygonGeometricoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PorygonGeometricoTheme {
                GeometryApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeometryApp() {
    var radius by remember { mutableStateOf(TextFieldValue("")) }
    var side by remember { mutableStateOf(TextFieldValue("")) }
    var base by remember { mutableStateOf(TextFieldValue("")) }
    var height by remember { mutableStateOf(TextFieldValue("")) }
    var area by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Porygon-Geometrico", color = Color(0xFFE25F6D), fontWeight = FontWeight.Bold)
                        Image(
                            painter = painterResource(id = R.drawable.poregon),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF52ABB4))
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color(0xFF52ABB4))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                item {
                    // Círculo
                    Text("Círculo", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Image(painter = painterResource(id = R.drawable.bola), contentDescription = null, modifier = Modifier.size(150.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Raio", color = Color.White)
                    BasicTextField(
                        value = radius,
                        onValueChange = { radius = it },
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { area = "Área do Círculo: ${(radius.text.toDoubleOrNull() ?: 0.0).let { Math.PI * it * it }}" },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE25F6D)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Calcular", color = Color.White)
                    }
                            Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    // Cubo
                    Text("Cubo", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Image(painter = painterResource(id = R.drawable.cubo), contentDescription = null, modifier = Modifier.size(150.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Lado", color = Color.White)
                    BasicTextField(
                        value = side,
                        onValueChange = { side = it },
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { area = "Área do Cubo: ${(side.text.toDoubleOrNull() ?: 0.0).let { 6 * it * it }}" },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE25F6D)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Calcular", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    // Pirâmide
                    Text("Pirâmide", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Image(painter = painterResource(id = R.drawable.piramide), contentDescription = null, modifier = Modifier.size(150.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Base", color = Color.White)
                    BasicTextField(
                        value = base,
                        onValueChange = { base = it },
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Altura", color = Color.White)
                    BasicTextField(
                        value = height,
                        onValueChange = { height = it },
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { area = "Área da Pirâmide: ${(base.text.toDoubleOrNull() ?: 0.0) * (height.text.toDoubleOrNull() ?: 0.0) / 2}" },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE25F6D)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Calcular", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    // Resultado
                    Text(area, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GeometryAppPreview() {
    PorygonGeometricoTheme {
        GeometryApp()
    }
}
