package me.benbarber.sked

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import me.benbarber.sked.ui.events.EventsScreen
import me.benbarber.sked.ui.theme.SkedTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkedTheme {
                ProvideWindowInsets {
                    EventsScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
            modifier = Modifier.statusBarsPadding(),
            text = "Hello $name!"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SkedTheme {
        Greeting("Android")
    }
}