package com.example.githubrepositoryclnart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GithubRepositoryNavigationHost() {
    val navController = rememberNavController()
    NavHost(modifier = Modifier.semantics { testTagsAsResourceId = true },navController = navController, startDestination = Screens.Home.route) {
        
    }
    
}