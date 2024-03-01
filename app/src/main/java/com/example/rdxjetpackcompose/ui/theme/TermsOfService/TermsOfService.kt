package com.example.rdxjetpackcompose.ui.theme.TermsOfService

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rdxjetpackcompose.R
import com.example.rdxjetpackcompose.ui.theme.NavGraph.NavigationItem
import com.example.rdxjetpackcompose.ui.theme.RDXJetPackComposeTheme



@Composable
fun TermsOfServiceScreen(navController: NavController) {

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


                    Text(
                        text = "TERMS OF SERVICE",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(modifier = Modifier.padding(8.dp))


                }

                Text(
                    text = stringResource(id = R.string.terms_of_service),
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodySmall
                )

                val checkedTermsOfService = remember { mutableStateOf(false) }
                var isEnabled by remember { mutableStateOf(false) }

                Row {
                    Checkbox(
                        checked = checkedTermsOfService.value,
                        onCheckedChange = { isChecked -> checkedTermsOfService.value = isChecked }
                    )
                    isEnabled = checkedTermsOfService.value
                    Text(text = "I  agree to the RDX Terms & Conditions",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(12.dp))
                }


                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = {navController.navigate(NavigationItem.credentials_screen.route) },
                           enabled = isEnabled
                          ) {
                        Text(text = "NEXT")
                    }
                }
            }

        }
    }

}