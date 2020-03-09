package com.example.myapplication

import android.util.Log
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.*
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

/**
 * Created by TranHuuPhuc on 3/9/20.
 */

@Composable
fun JCButton() {
    MaterialTheme {
        Column {
            //Normal button
            Button(
                onClick = onEventClick(),
                elevation = 4.dp,
                modifier = LayoutPadding(all = 10.dp)
            ) {
                Text(text = "Button")
            }

            //TextButton
            TextButton(
                onClick = onEventClick()
            ) {
                Text(text = "TextButton")
            }

            //OutlinedButton
            OutlinedButton(onClick = { /* Do something! */ }) {
                Text("Outlined Button")
            }

            //Icon Button
            IconButton(
                onClick = {

                }
            ) {
                DrawVector(
                    vectorImage = vectorResource(R.drawable.ic_baseline_add_24),
                    tintColor = Color.Blue
                )
            }

            //IconToggleButton
            val checkedChange = state { false }
            IconToggleButton(
                checked = checkedChange.value,
                onCheckedChange = {
                    checkedChange.value = it
                }
            ) {
                if (checkedChange.value) {
                    DrawVector(
                        vectorImage = vectorResource(R.drawable.ic_baseline_add_24),
                        tintColor = Color.Blue
                    )
                } else {
                    DrawVector(
                        vectorImage = vectorResource(R.drawable.ic_baseline_add_24),
                        tintColor = Color.Red
                    )
                }
            }

            //FloatingActionButton
            FloatingActionButton() {
                DrawVector(
                    vectorImage = vectorResource(R.drawable.ic_baseline_add_24),
                    tintColor = Color.White
                )
            }

        }
    }
}

fun onEventClick(): () -> Unit = {
    Log.e("COMPOSE", "onEventClick")
}