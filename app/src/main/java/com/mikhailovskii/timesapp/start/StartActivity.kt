package com.mikhailovskii.timesapp.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikhailovskii.timesapp.R
import com.mikhailovskii.timesapp.login.LoginActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        log_in_button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

}