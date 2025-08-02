package com.example.githubrepositoryclnart.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity :ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            GitHubRepositoryClnArtTheme {
                    Surface {

                    }
            }
        }
    }
}