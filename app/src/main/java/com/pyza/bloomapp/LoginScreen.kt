package com.pyza.bloomapp


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pyza.bloomapp.ui.theme.BloomAppTheme


@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogInHeader()

            EmailInput()

            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )

            PasswordInput()

            TermsOfServiceLabel()

            Spacer(modifier = Modifier.height(16.dp))

            LoginButton(navController)
        }
    }
}

@Composable
private fun LoginButton(navController: NavController) {
    BloomSecondaryButton(
        buttonText = "Log in",
        onClick = {
            navController.navigate("home")
        }
    )
}

@Composable
private fun TermsOfServiceLabel() {
    Text(
        text = "By clicking below you agree to our Terms of use and consent to our Privacy Policy.",
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .paddingFromBaseline(top = 24.dp)
    )
}

@Composable
private fun PasswordInput() {
    val text = remember { mutableStateOf("") }
    OutlinedTextField(
        value = text.value,
        onValueChange = { newText ->
            text.value = newText
        },
        label = {
            Text(text = "Password (8+ characters)")
        },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions().copy(
            keyboardType = KeyboardType.Password
        )
    )
}

@Composable
private fun EmailInput() {
    val text = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text.value,
        onValueChange = { newText ->
            text.value = newText
        },
        label = {
            Text(text = "Email address")
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun LogInHeader() {
    Text(
        text = "Log in with email",
        modifier = Modifier
            .paddingFromBaseline(
                top = 184.dp,
                bottom = 16.dp
            )
    )
}

@Preview
@Composable
private fun previewDarkLoginScreen() {
    BloomAppTheme(darkTheme = true) {
        LoginScreen(rememberNavController())
    }
}

@Preview
@Composable
private fun previewLightLoginScreen() {
    BloomAppTheme(darkTheme = false) {
        LoginScreen(rememberNavController())
    }
}