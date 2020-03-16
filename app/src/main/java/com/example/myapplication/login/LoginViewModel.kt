package com.example.myapplication.login

import android.util.Log
import androidx.compose.Model
import androidx.lifecycle.ViewModel

/**
 * Created by TranHuuPhuc on 3/16/20.
 */
class LoginViewModel : ViewModel() {
    fun validLogin() {
        if (model.email != "" && model.password != "") {
            Log.e("PHUC", model.email + " - " + model.password)
        } else {
            Log.e("PHUC", "Empty")
        }
    }

    private var _model: LoginModel = LoginModel()

    var model
        get() = this._model
        set(value) {
            this._model = value
        }
}

@Model
class LoginModel(
    var email: String = "",
    var password: String = ""
)