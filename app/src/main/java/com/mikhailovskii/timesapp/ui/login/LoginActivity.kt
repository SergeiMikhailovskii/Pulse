package com.mikhailovskii.timesapp.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikhailovskii.timesapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login_btn.setOnClickListener {
            val loginModal = LoginModal()
            loginModal.show(supportFragmentManager, null)
        }

    }

}
