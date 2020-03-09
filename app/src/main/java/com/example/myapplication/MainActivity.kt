package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.material.BottomAppBar
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.Scaffold
import androidx.ui.res.vectorResource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topAppBar = {

                },

                bodyContent = {
                    VerticalScroller() {
                        JCButton()
                    }
                },

                bottomAppBar = {
                    BottomAppBar(color = Color.Red) {

                    }
                },

                drawerContent = {

                },

                floatingActionButton = {
                    FloatingActionButton() {
                        DrawVector(
                            vectorImage = vectorResource(R.drawable.ic_baseline_add_24),
                            tintColor = Color.White
                        )
                    }
                },

                floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked
            )
        }
    }
}
