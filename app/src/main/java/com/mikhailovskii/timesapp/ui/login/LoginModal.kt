package com.mikhailovskii.timesapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mikhailovskii.timesapp.R
import com.mikhailovskii.timesapp.util.Result
import kotlinx.android.synthetic.main.fragment_login_modal.*

class LoginModal : BottomSheetDialogFragment() {

    private val viewModelFactory = ViewModelProvider.NewInstanceFactory()
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_modal, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                Result.Loading -> {
                    println("Loading")
                }
                is Result.Success -> {
                    println(it.data)
                }
                Result.Error -> {
                    println("Error")
                }
            }
        })

        log_in_button.setOnClickListener {
            viewModel.logInUser("Sergei", "12345")
        }

    }
}
