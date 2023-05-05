package de.ulme.findyourcorevalues

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.ulme.findyourcorevalues.ui.theme.FindYourCoreValuesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindYourCoreValuesTheme {
                YourValuesApp()
            }
        }
    }
}