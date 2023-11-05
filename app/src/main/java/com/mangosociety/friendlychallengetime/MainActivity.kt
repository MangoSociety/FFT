package com.mangosociety.friendlychallengetime

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.mangosociety.friendlychallengetime.shared.di.initKoin
import com.mangosociety.friendlychallengetime.shared.ui.root.RootContentShared
import com.mangosociety.friendlychallengetime.shared.ui.theme.BakgroundColor
import com.mangosociety.friendlychallengetime.ui.theme.FriendlyChallengeTimeTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val root = DefaultRootComponent(componentContext = defaultComponentContext())

//        val backgroundArgb = Color(0xFFF19 window, false)

        val rootComponent = com.mangosociety.friendlychallengetime.shared.ui.root.DefaultRootComponent(
            componentContext = defaultComponentContext(),
            storeFactory = DefaultStoreFactory()
        )

        initKoin(
            enableNetworkLogs = true
        ) {
            androidContext(applicationContext)
        }

        setContent {
            FriendlyChallengeTimeTheme {

                val statusBarColor by remember { mutableStateOf(BakgroundColor) }

                // Получите доступ к контексту активности
                val context = LocalContext.current

                // Создайте SystemUiController
                val systemUiController = rememberUpdatedState(SystemUiController(context))

                // Установите цвет статус-бара
                LaunchedEffect(statusBarColor) {
                    systemUiController.value.setStatusBarColor(statusBarColor)
                }
//
//                RootContent(component = root)
                RootContentShared(component = rootComponent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}

class SystemUiController(private val context: Context) {

    fun setStatusBarColor(color: androidx.compose.ui.graphics.Color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = (context as Activity).window
            window.statusBarColor = color.toArgb()
        }
    }

    // Другие методы для управления системными UI-элементами

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FriendlyChallengeTimeTheme {
        Greeting("Android")
    }
}
