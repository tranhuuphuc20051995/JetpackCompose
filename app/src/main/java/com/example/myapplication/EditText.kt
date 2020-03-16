package com.example.myapplication

import androidx.compose.Composable
import androidx.ui.core.Layout
import androidx.ui.core.LayoutTag
import androidx.ui.core.tag
import androidx.ui.layout.Container
import androidx.ui.unit.ipx

/**
 * Created by TranHuuPhuc on 3/16/20.
 */
@Composable
fun HintEditText(
    hintText: @Composable() () -> Unit,
    textField: @Composable() () -> Unit,
    state: String,
    inputFieldTag: String = "inputFieldTag",
    hintTag: String = "hintTag"
) {
    if (state.isNotEmpty()) {
        Container(LayoutTag(inputFieldTag) ,children = textField)
    } else {
        Layout({
            Container(LayoutTag(inputFieldTag), children = textField)
            Container(LayoutTag(hintTag), children = hintText)
        }) { measurable, constraints ->
            val inputFieldPlacable =
                measurable.first { it.tag == inputFieldTag }.measure(constraints)
            val hintTextPlaceable = measurable.first { it.tag == hintTag }.measure(constraints)
            layout(inputFieldPlacable.width, inputFieldPlacable.height) {
                inputFieldPlacable.place(0.ipx, 0.ipx)
                hintTextPlaceable.place(0.ipx, 0.ipx)
            }
        }
    }
}