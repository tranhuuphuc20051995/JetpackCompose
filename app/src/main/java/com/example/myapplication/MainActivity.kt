package com.example.myapplication

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.vectorResource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCButton()
        }
    }
}

@Composable
fun JCButton() {
    MaterialTheme {
        Column {
            //Normal button
            Button(
                text = "Button",
                onClick = {

                }
            )
            HeightSpacer(height = 10.dp)
            //Custom style button
            Button(
                text = "Button",
                onClick = {

                },
                style = OutlinedButtonStyle(
                    color = Color.White,
                    contentColor = Color.DarkGray,
                    border = androidx.ui.foundation.shape.border.Border(Color.DarkGray, Dp(1f)),
                    elevation = Dp(1f)
                )
            )
            HeightSpacer(height = 10.dp)
            //Button custom
            Button(
                children = {
                    Column {
                        Container(
                            width = 50.dp,
                            height = 50.dp
                        ) {
                            VectorImage(id = R.drawable.ic_baseline_add_24)
                        }
                        Text(text = "Hello")
                        Text(text = "Button")
                    }
                },
                style = OutlinedButtonStyle(
                    Border(color = Color.Red, width = 1.dp),
                    shape = RoundedCornerShape(50), //50% percent
                    contentColor = Color.Red
                )
            )
        }
    }
}

@Composable
fun VectorImage(@DrawableRes id: Int, tintColor: Color = Color.Blue) {
    val vector = +vectorResource(id)
    WithDensity {
        Container(
            width = 50.dp,
            height = 50.dp
        ) {
            DrawVector(vectorImage = vector, tintColor = tintColor)
        }
    }
}
