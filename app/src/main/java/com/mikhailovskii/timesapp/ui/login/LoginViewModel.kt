package com.mikhailovskii.timesapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mikhailovskii.timesapp.data.entity.User
import com.mikhailovskii.timesapp.util.Result

class LoginViewModel : ViewModel() {

    var user: MutableLiveData<Result<User>> = MutableLiveData()

    private val loginRepository = LoginRepository(user)

    fun logInUser(login: String, password: String) {
        loginRepository.fetchUser(login, password)
    }

}