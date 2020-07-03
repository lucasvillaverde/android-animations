package dev.lucasvillaverde.androidloginanimation

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateStatusBar()
        setBtnListeners()
    }

    private fun updateStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setBtnListeners() {
        btnSignUp.isEnabled = false
        btnSignUp.alpha = 0.4F
        btnSignUp.setOnTouchListener(onTouch())
        btnSignIn.setOnTouchListener(onTouch())
    }

    private fun onTouch(): View.OnTouchListener {
        return View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> view.animate().alpha(0.4F).setDuration(100).start()
                MotionEvent.ACTION_UP -> view.animate().alpha(1F).setDuration(100).start()
            }
            view.performClick()
            true
        }
    }
}