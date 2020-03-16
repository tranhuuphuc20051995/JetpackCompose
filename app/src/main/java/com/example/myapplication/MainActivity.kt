package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Model
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.BottomAppBar
import androidx.ui.material.Button
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.Scaffold
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)

        setContent {
            viewModel.model = ModelStateComposer()
            Scaffold(
                topAppBar = {

                },

                bodyContent = {
                    VerticalScroller() {
                        Button(
                            onClick = onEventClick(),
                            elevation = 4.dp,
                            modifier = LayoutPadding(all = 10.dp)
                        ) {
                            Text(text = viewModel.model.textState)
                        }
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
                    FloatingActionButton(onClick = {

                    }) {
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

    private fun onEventClick(): () -> Unit = {
        viewModel.setValue("Cái éo nhé!")
        setContent {
            JCButton()
        }
    }
}

@Model
class ModelStateComposer(var textState: String = "Hello") {
}