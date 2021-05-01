package com.fabirt.podcastapp.ui.welcome

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.fabirt.podcastapp.ui.common.PreviewContent
import com.fabirt.podcastapp.ui.navigation.Destination
import com.fabirt.podcastapp.ui.navigation.Navigator

@ExperimentalAnimationApi
@Composable
fun WelcomeScreen() {
    var visible by remember { mutableStateOf(false) }
    val navController = Navigator.current

    LaunchedEffect(true) {
        visible = true
    }

    WelcomeScreenContent(visible = visible) {
        navController.navigate(Destination.home) {
            popUpTo(Destination.welcome) { inclusive = true }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun WelcomeScreenContent(
    visible: Boolean,
    onGetStarted: () -> Unit
) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            AnimatedTitle(visible = visible)

            AnimatedImage(visible = visible)

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedButton(visible = visible, onClick = onGetStarted)
        }
    }
}

@ExperimentalAnimationApi
@Preview(name = "Welcome")
@Composable
fun WelcomeScreenPreview() {
    PreviewContent {
        WelcomeScreenContent(visible = true) { }
    }
}

@ExperimentalAnimationApi
@Preview(name = "Welcome (Dark)")
@Composable
fun WelcomeScreenDarkPreview() {
    PreviewContent(darkTheme = true) {
        WelcomeScreenContent(visible = true) { }
    }
}