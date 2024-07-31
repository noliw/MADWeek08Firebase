package com.example.madweek08firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.madweek08firebase.account.AccountViewModel
import com.example.madweek08firebase.ui.FirebaseApp
import com.example.madweek08firebase.ui.theme.MADWeek08FirebaseTheme

class MainActivity : ComponentActivity() {

    // Lazy initialization of AccountViewModel using Hilt's viewModels delegate
    private val accountViewModel: AccountViewModel by viewModels<AccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            // Observe the startDestination state from the AccountViewModel
            val startDestination by accountViewModel.startDestination.collectAsState()

            // Pass the startDestination to the FirebaseApp composable
            FirebaseApp(startDestination = startDestination)
        }
    }
}