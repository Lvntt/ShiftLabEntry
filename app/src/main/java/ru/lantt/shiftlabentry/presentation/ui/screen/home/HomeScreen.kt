package ru.lantt.shiftlabentry.presentation.ui.screen.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.event.LoginEvent
import ru.lantt.shiftlabentry.presentation.ui.navigation.ShiftLabEntryDestinations
import ru.lantt.shiftlabentry.presentation.ui.screen.home.components.GreetingButton
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraLarge
import ru.lantt.shiftlabentry.presentation.uistate.HomeUiState
import ru.lantt.shiftlabentry.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    navController: NavController
) {
    val homeUiState by remember { viewModel.homeUiState }

    Crossfade(targetState = homeUiState, label = "") { state ->
        when (state) {
            HomeUiState.Loading -> HomeLoadingScreen()
            HomeUiState.Content -> HomeContentScreen(
                viewModel = viewModel
            )
        }
    }
    
    LaunchedEffect(key1 = LocalContext.current) {
        viewModel.loginState.collect { state ->
            when (state) {
                LoginEvent.RegistrationRequired -> {
                    navController.navigate(ShiftLabEntryDestinations.REGISTRATION)
                }
            }
        }
    }
}

@Composable
private fun HomeContentScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingButton(viewModel = viewModel)
    }
}

@Composable
fun HomeLoadingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cft_logo),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = PaddingExtraLarge)
        )
    }
}

@Preview
@Composable
fun HomeLoadingScreenPreview() {
    HomeLoadingScreen()
}