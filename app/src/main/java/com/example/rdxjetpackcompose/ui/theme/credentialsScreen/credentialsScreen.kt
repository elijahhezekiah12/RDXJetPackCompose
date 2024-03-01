package com.example.rdxjetpackcompose.ui.theme.credentialsScreen

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.di.SharedPreferencesStorage
import com.example.rdxjetpackcompose.service.PreferencesManager
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme
import com.example.rdxjetpackcompose.ui.theme.mainScreen.mainScreenViewModel
import com.example.rdxjetpackcompose.util.Constants.EMAIL


@Composable
fun CredentialsScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel = credentialsViewModel ()
    val SharedPreferencesStorage = SharedPreferencesStorage(context)
    RDXJetPackComposeTheme {
        Surface {
            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            val preferencesManager = remember { PreferencesManager( context,SharedPreferencesStorage.sharedPreferencesInject()) }
            Column(
                modifier = Modifier
                    .padding(30.dp, 30.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(30.dp, 2.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {


                    Text(
                        text = "PLEASE ENTER YOUR CREDENTIALS",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(modifier = Modifier.padding(8.dp))


                }

                val focusManager = LocalFocusManager.current

                TextField(
                    value = email,
                    onValueChange = {email = it},
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    placeholder = {
                        Text("Enter Your Email Address", color = Color.Gray)
                    }
                )

                Spacer(modifier = Modifier.padding(16.dp))

                TextField(
                    value = password,
                    onValueChange = {password = it },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    ),
                    placeholder = {
                        Text("Choose Password", color = Color.Gray)
                    },
                    visualTransformation =PasswordVisualTransformation()
                )

                var isEnabled by remember { mutableStateOf(false) }
                isEnabled = email.isNotEmpty() && viewModel.validateEmail(email) && password.isNotEmpty()


                Spacer(modifier = Modifier.padding(16.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = {navController.navigate(NavigationItem.personal_info_screen.route)
                                      preferencesManager.saveData(EMAIL,email)
                                     },
                          enabled = isEnabled
                         ) {
                        Text(text = "NEXT")
                    }
                }
            }

        }
    }

}

fun checkCredentials(email :String, password:String):Boolean{
      return  email.isNotEmpty() && password.isNotEmpty()
}