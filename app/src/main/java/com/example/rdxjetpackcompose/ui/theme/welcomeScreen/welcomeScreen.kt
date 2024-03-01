package com.example.rdxjetpackcompose.ui.theme.welcomeScreen

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.R
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme



@Composable
fun WelcomeScreen(navController: NavController) {
    RDXJetPackComposeTheme {
        Surface {
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
                    val image: Painter = painterResource(id = R.drawable.playstore)
                    Image(painter = image, contentDescription = "")


                    Spacer(modifier = Modifier.padding(8.dp))


                    Text(
                        text = "WELCOME TO RDX",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.padding(8.dp))
                }


                Spacer(modifier = Modifier.padding(16.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = { navController.navigate(NavigationItem.terms_of_service.route)}) {
                        Text(text = "NEXT")
                    }
                }
            }

        }
    }

}

