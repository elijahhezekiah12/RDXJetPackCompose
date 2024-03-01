@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.rdxjetpackcompose.ui.theme.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.R
import com.example.rdxjetpackcompose.di.SharedPreferencesStorage
import com.example.rdxjetpackcompose.service.PreferencesManager
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme


@Composable
fun MainScreen(navController: NavController) {

    val context = LocalContext.current
    val SharedPreferencesStorage = SharedPreferencesStorage(context)
    var preferencesManager = PreferencesManager(context,SharedPreferencesStorage(context).sharedPreferencesInject())
    val viewModel = mainScreenViewModel (context,preferencesManager)
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
                }

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(id = R.string.first_name),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = viewModel.setUserFirstName(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.padding(8.dp))


                Text(
                    text = stringResource(id = R.string.last_name),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = viewModel.setUserLastName()?.ifEmpty { "Smith" } ?: "Smith" ,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = stringResource(id = R.string.telephone),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = viewModel.setUserTelephone()?.ifEmpty { "077777777" } ?:"077777777" ,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = stringResource(id = R.string.email),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = viewModel.setUserEmail()?.ifEmpty { "ellla_smith@rdx.com" } ?:"ellla_smith@rdx.com" ,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = { navController.navigate(NavigationItem.Welcome.route)}) {
                        Text(text = "Sign Out")
                    }
                }
            }

        }
    }

}



