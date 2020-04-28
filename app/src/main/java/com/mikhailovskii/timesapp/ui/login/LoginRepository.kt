package com.mikhailovskii.timesapp.ui.login

import androidx.lifecycle.MutableLiveData
import com.mikhailovskii.timesapp.data.entity.User
import com.mikhailovskii.timesapp.util.Result

class LoginRepository(private val user: MutableLiveData<Result<User>>) {

    fun fetchUser(login: String, password: String) = run {
        if (login == "Sergei" && password == "12345") {
            user.postValue(Result.Success(User(login, password)))
        }
    }

}