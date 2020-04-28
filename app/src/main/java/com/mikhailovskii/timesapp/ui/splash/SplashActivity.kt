package com.mikhailovskii.timesapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mikhailovskii.timesapp.R
import com.mikhailovskii.timesapp.ui.start.StartActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private val splashScreenTime = 3000L
    private val percentsStep = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var loadingProgress = 0

        CoroutineScope(Dispatchers.IO).launch {
            delay(splashScreenTime)
            withContext(Dispatchers.Main) {
                startActivity(Intent(applicationContext, StartActivity::class.java))
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            for (i in 0 until 100 / percentsStep) {
                delay(splashScreenTime * percentsStep / 100)
                withContext(Dispatchers.Main) {
                    loading_percents_tv.text = applicationContext.resources.getString(R.string.loading_value, loadingProgress)
                    loadingProgress += percentsStep
                    println(loadingProgress)
                }
            }
        }

    }


}