package com.example.rdxjetpackcompose.ui.theme.ConfirmPInScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme


@Composable
fun ConfirmPinScreen(navController: NavController,chosenPin:String) {

    RDXJetPackComposeTheme {
        Surface {
            var pin by rememberSaveable { mutableStateOf("") }
            Column(
                modifier = Modifier
                    .padding(30.dp, 30.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {


                TextField(
                    value = pin,
                    onValueChange = {pin = it},
                    placeholder = {
                        Text("Confirm PIN", color = Color.Gray)
                    }
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Please re-enter your pin code",
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.titleSmall
                )


                Spacer(modifier = Modifier.padding(8.dp))

                Log.d("this is the pin",chosenPin)

                Log.d("confirm pin",pin)

                val isEnabled = pin.isNotEmpty()

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = {if(chosenPin ==pin){navController.navigate(NavigationItem.Main.route)} },
                        enabled = isEnabled
                         ) {
                        Text(text = "CONFIRM")
                    }
                }
            }

        }
    }

}