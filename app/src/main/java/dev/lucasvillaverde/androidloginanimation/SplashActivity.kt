package dev.lucasvillaverde.androidloginanimation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Just simulating loader... Delaying for 3 seconds.
        val handler = Handler()
        handler.postDelayed(Runnable {
            kotlin.run {
                finishLoading()
            }
        }, 3000)
    }

    private fun finishLoading() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}