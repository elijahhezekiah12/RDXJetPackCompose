package com.example.rdxjetpackcompose.ui.theme.personalInfoScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.di.SharedPreferencesStorage
import com.example.rdxjetpackcompose.service.PreferencesManager
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme
import com.example.rdxjetpackcompose.util.Constants


@Composable
fun PersonalInfoScreen(navController: NavController) {
    val context = LocalContext.current

    RDXJetPackComposeTheme {
        Surface {
            var firstName by rememberSaveable { mutableStateOf("") }
            var lastName by rememberSaveable { mutableStateOf("") }
            var telephone by rememberSaveable { mutableStateOf("") }
            val preferencesManager = remember { PreferencesManager( context,
                SharedPreferencesStorage(context).sharedPreferencesInject()) }
           // val preferencesManager = remember { PreferencesManager( context) }

            val viewModel = personalInfoScreenViewModel()
            Column(
                modifier = Modifier
                    .padding(30.dp, 30.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {


                    Text(
                        text = "Personal Info",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                }

                TextField(
                    value = firstName,
                    onValueChange = {firstName=it},
                    placeholder = {
                        Text("First Name", color = Color.Gray)
                    }
                )

                Spacer(modifier = Modifier.padding(16.dp))

                TextField(
                    value = lastName,
                    onValueChange = {lastName =it},
                    placeholder = {
                        Text("Last Name", color = Color.Gray)
                    }
                )

                Spacer(modifier = Modifier.padding(16.dp))

                TextField(
                    value = telephone,
                    onValueChange = {telephone =it},
                    placeholder = {
                        Text("Enter Phone Number", color = Color.Gray)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

                Spacer(modifier = Modifier.padding(16.dp))

                var isEnabled by remember { mutableStateOf(false) }
                isEnabled = viewModel.firstNameisNotEmpty(firstName)
                            && viewModel.lasttNameisNotEmpty(lastName)
                            && viewModel.validateTelephone(telephone)

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = {navController.navigate(NavigationItem.choose_pin.route)
                                      preferencesManager.saveData(Constants.FIRST_NAME,firstName)
                                      preferencesManager.saveData(Constants.LAST_NAME,lastName)
                                      preferencesManager.saveData(Constants.TELEPHONE,telephone)
                                     },
                         enabled = isEnabled) {
                        Text(text = "NEXT")
                    }
                }
            }

        }
    }

}