package com.example.nav

import android.os.Bundle
import android.security.keystore.StrongBoxUnavailableException
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aula_21_03.ui.theme.Aula2103Theme
import com.example.nav.screens.MoviesScreen
import com.example.nav.screens.NewsScreen
import com.example.nav.screens.SeriesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula2103Theme {
                App()
            }
        }
    }
}

interface Route {
    val name: String
    val screen: @Composable () -> Unit
}

object Routes {
    object Movies : Route {
        override val name = "movies"
        override val screen = @Composable { MoviesScreen() }
    }
    object Series : Route {
        override val name = "series"
        override val screen = @Composable { SeriesScreen() }
    }
    object News : Route {
        override val name = "news"
        override val screen = @Composable { NewsScreen() }
    }
}

val routes = listOf(
    Routes.Movies,
    Routes.Series,
    Routes.News
)

@Composable
fun App() {
    val navController = rememberNavController()
    Scaffold (
        topBar = {
            MyAppBar(
                routes = routes,
                onItemClicked = { routeName ->
                    navController.navigate(
                        routeName
                    ) {
                        popBackStack(Routes.Movies.name, false)
                        launchSingleTop = true
                    }
                },

            )
        }
    ){
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = routes[0].name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Routes.Movies.name){
                MoviesScreen()
            }
            composable(route = routes[1].name){
                SeriesScreen()
            }
            composable(route = routes[2].name){
                NewsScreen()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MoviesScreenPreview() {
    Aula2103Theme {
        MoviesScreen()
    }
}

@Composable
@Preview(showBackground = true)
fun SeriesScreenPreview() {
    Aula2103Theme {
        SeriesScreen()
    }
}

@Composable
@Preview(showBackground = true)
fun NewsScreenPreview() {
    Aula2103Theme {
        NewsScreen()
    }
}

@Composable
@Preview(showBackground = true)
fun AppPreview() {
    Aula2103Theme {
        App()
    }
}