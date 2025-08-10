package com.example.githubrepositoryclnart.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.githubrepositoryclnart.ui.navigation.GithubRepositoryNavigationHost
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity :ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubRepositoryClnArtTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    GithubRepositoryNavigationHost()
                }
            }
        }
    }

}