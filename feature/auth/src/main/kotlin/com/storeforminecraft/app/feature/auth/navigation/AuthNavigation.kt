package com.storeforminecraft.app.feature.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object AuthRoute

@Serializable
data object AuthSelectionRoute

@Serializable
data object SignInRoute

@Serializable
data object SignUpRoute

@Serializable
data object ForgotPasswordRoute

fun NavGraphBuilder.authNavGraph() {
    navigation<AuthRoute>(
        startDestination = AuthSelectionRoute
    ) {
        composable<AuthSelectionRoute> {

        }
        composable<SignInRoute> {

        }
        composable<SignUpRoute> {

        }
    }
}