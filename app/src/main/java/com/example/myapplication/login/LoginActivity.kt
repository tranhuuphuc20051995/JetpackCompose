package com.example.myapplication.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Box
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.EdgeInsets
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.unit.Size
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.myapplication.HintEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        setContent {
            MaterialTheme {
                Column {
                    Box(shape = RectangleShape, border = Border(1.dp, color = Color.DarkGray)) {
                        Container(padding = EdgeInsets(all = 8.dp)) {
                            HintEditText(
                                hintText = {
                                    Text(
                                        text = "Email",
                                        style = TextStyle(fontSize = 12.sp, color = Color.LightGray)
                                    )
                                },
                                state = viewModel.model.email,
                                textField = {
                                    TextField(
                                        value = viewModel.model.email,
                                        onValueChange = { viewModel.model.email = it },
                                        textStyle = TextStyle(fontSize = 16.sp)
                                    )
                                },
                                hintTag = "hintEmailTag",
                                inputFieldTag = "inputEmailTag"
                            )
                        }
                    }
                    Divider(height = 16.dp)
                    Size(width = 0.dp, height = 16.dp)
                    Box(shape = RectangleShape, border = Border(1.dp, color = Color.DarkGray)) {
                        Container(padding = EdgeInsets(all = 8.dp)) {
                            HintEditText(
                                hintText = {
                                    Text(
                                        text = "Password",
                                        style = TextStyle(fontSize = 12.sp, color = Color.LightGray)
                                    )
                                },
                                state = viewModel.model.password,
                                textField = {
                                    TextField(
                                        value = viewModel.model.password,
                                        onValueChange = { viewModel.model.password = it },
                                        textStyle = TextStyle(fontSize = 16.sp)
                                    )
                                },
                                hintTag = "hintPasswordTag",
                                inputFieldTag = "inputPasswordTag"
                            )

                        }
                    }
                    Divider(height = 16.dp)
                    Button(
                        onClick = onEventClick(),
                        elevation = 4.dp,
                        modifier = LayoutPadding(all = 10.dp)
                    ) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }

    private fun onEventClick(): () -> Unit = {
        viewModel.validLogin()
    }
}
