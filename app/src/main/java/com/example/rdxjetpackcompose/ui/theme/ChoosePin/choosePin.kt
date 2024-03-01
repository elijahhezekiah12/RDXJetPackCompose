package com.example.rdxjetpackcompose.ui.theme.ChoosePin

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme



@Composable
fun ChoosePinScreen(navController: NavController) {

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
                    onValueChange = {pin =it},
                    placeholder = {
                        Text("Choose PIN", color = Color.Gray)
                    }
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Please enter your pin code",
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.titleSmall
                )


                Spacer(modifier = Modifier.padding(8.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = { navController.navigate(NavigationItem.confirm_pin.route+"/$pin")},

                        enabled = pin.isNotEmpty()) {
                        Text(text = "NEXT")
                    }
                }
            }

        }
    }

}