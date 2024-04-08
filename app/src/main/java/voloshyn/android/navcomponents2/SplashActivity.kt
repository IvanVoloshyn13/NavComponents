package voloshyn.android.navcomponents2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import voloshyn.android.navcomponents2.screens.splash.SplashFragment
import voloshyn.android.navcomponents2.screens.splash.SplashViewModel

/**
 * Entry point of the app
 *
 * Splash activity contains only window background, all other initialization logic is placed to
 * [SplashFragment] and [SplashViewModel]
 */

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SPLASH", "ACT")
        setContentView(R.layout.activity_splash)
    }
}