package dev.lucasvillaverde.androidloginanimation

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import dev.lucasvillaverde.androidloginanimation.utils.DateUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAnimations()
        updateUI()
        setBtnListeners()
    }

    private fun updateUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }

        if (DateUtils.getDayTimePeriod() == DateUtils.MORNING) {
            mainRootLayout.setBackgroundResource(R.drawable.good_morning_bg)
            txtGreeting.text = getString(R.string.good_morning_text)
            txtGreetingSubtitle.text = getString(R.string.good_morning_subtitle)
        } else {
            mainRootLayout.setBackgroundResource(R.drawable.good_night_bg)
            txtGreeting.text = getString(R.string.good_night_text)
            txtGreetingSubtitle.text = getString(R.string.good_night_subtitle)
        }

    }

    private fun setAnimations() {
        llInputs.animation = AnimationUtils.loadAnimation(this, R.anim.animation_login_inputs)
        txtGreeting.animation = AnimationUtils.loadAnimation(this, R.anim.animation_greeting)
        txtGreetingSubtitle.animation =
            AnimationUtils.loadAnimation(this, R.anim.animation_greeting_subtitle)
        btnSignUp.animation = AnimationUtils.loadAnimation(this, R.anim.animation_alpha_login_1500)
        btnSignIn.animation = AnimationUtils.loadAnimation(this, R.anim.animation_alpha_login_1500)
        txtBtnForgotPassword.animation =
            AnimationUtils.loadAnimation(this, R.anim.animation_alpha_login_1500)
    }

    private fun setBtnListeners() {
        btnSignUp.isEnabled = false
        btnSignUp.alpha = 0.4F
        btnSignUp.setOnTouchListener(onTouch())
        btnSignIn.setOnTouchListener(onTouch())
    }

    // Click button animation
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

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, SplashActivity::class.java))
    }
}