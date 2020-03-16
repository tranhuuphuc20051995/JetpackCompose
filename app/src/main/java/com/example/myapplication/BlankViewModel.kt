package com.example.myapplication

import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    fun setValue(newValue: String) {
        model.textState = newValue
    }

    lateinit var model: ModelStateComposer
}