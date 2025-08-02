package com.example.githubrepositoryclnart.ui.navigation

import com.example.presentation.util.Constants.Companion.DETAILS_SCREEN
import com.example.presentation.util.Constants.Companion.HOME_SCREEN
import com.example.presentation.util.Constants.Companion.ISSUES_SCREEN
import com.example.presentation.util.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.presentation.util.Constants.Companion.OWNER_ARGUMENT_KEY

sealed class Screens(val route: String) {

    data object Home : Screens(route = HOME_SCREEN)


    data object Details :
        Screens(route = "$DETAILS_SCREEN/{$OWNER_ARGUMENT_KEY}/{$NAME_ARGUMENT_KEY") {
        fun passOwnerAddName(owner: String, name: String): String {
            return "$DETAILS_SCREEN/$owner/$name"
        }
    }

    data object Issues :
        Screens(route = "$ISSUES_SCREEN/{$OWNER_ARGUMENT_KEY}/{$NAME_ARGUMENT_KEY}") {
        fun passOwnerName(owner: String, name: String): String {
            return "$ISSUES_SCREEN/$owner/$name"
        }
    }


}