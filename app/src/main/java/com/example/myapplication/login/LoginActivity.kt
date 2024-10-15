package com.example.myapplication.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.bodyFontFamily

//class LoginActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AppTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color(0xFF0D1B2A) // Set background color to match the image
//                ) {
//                    LoginScreen()
//                }
//            }
//        }
//    }
//}

import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
//import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.compose.LocalLifecycleOwner

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                LoginUI()
            }
        }
    }
}

@Composable
fun LoginUI() {
    val loginViewModel = LoginViewModel()

    var userName by remember { mutableStateOf("")}
    var password by remember {mutableStateOf("") }

    val lifeCicleOwner = LocalLifecycleOwner.current
    val localContext = LocalContext.current

    fun updateUI(loginState: LoginViewModel.LoginState) {
        when ( loginState) {
            is LoginViewModel.LoginState.Loading -> {
                Toast.makeText(
                    localContext,
                    "Cargando",
                    Toast.LENGTH_SHORT
                ).show()
            }
            is LoginViewModel.LoginState.DoLogin -> {
                Toast.makeText(
                    localContext,
                    loginState.message,
                    Toast.LENGTH_LONG
                ).show()
            }

            is LoginViewModel.LoginState.Error -> {
                Toast.makeText(
                    localContext,
                    loginState.message,
                    Toast.LENGTH_LONG
                ).show()
            }
            LoginViewModel.LoginState.LoggedOut -> {
                Toast.makeText(
                    localContext,
                    "LogOut",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
    loginViewModel.state.observe(
        lifeCicleOwner,
        Observer(::updateUI)

    )

    Scaffold {
            innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            Text(
                text = "Login",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = userName,
                onValueChange = {
                    userName = it
                }
            )
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                visualTransformation = PasswordVisualTransformation()

            )
            Button(
                onClick = {
                    loginViewModel.doLogin(
                        userName,
                        password
                    )
                }
            ) {
                Text(
                    text = "SignIn"
                )
            }
        }
    }

}

@Preview
@Composable
fun preview() {
    LoginUI()
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    //userViewModel.getUsers(context)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontFamily = bodyFontFamily,
            text = "RateFilm",
            fontSize = 36.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 64.dp),
        )

        // Email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Nombre o correo electrónico:", color = Color.Gray) },
            placeholder = { Text("tuCorreoAqui@gmail.com", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                //textColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña:", color = Color.Gray) },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                //textColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        // Login button
        Button(
            onClick = {  },
            //colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)), // Orange color
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                text = "Iniciar sesión",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}