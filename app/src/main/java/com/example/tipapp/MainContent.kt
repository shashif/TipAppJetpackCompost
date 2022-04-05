package com.example.tipapp


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipapp.components.InputField
import com.example.tipapp.widgets.RoundIconButton

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun MainContent() {

    BillForm { billAmount ->
        Log.d("AMT", "MainContent: ${billAmount.toInt() * 100}")
    }

}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValchange: (String) -> Unit = {}
) {


    val totalBillState = remember {
        mutableStateOf("")
    }

    val valiedState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }

    val keyboardController = LocalSoftwareKeyboardController.current
val sliderPositionState = remember {
    mutableStateOf(0f)
}
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        //.clip(shape = RoundedCornerShape(corner = CornerSize(15.dp))),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)

    ) {

        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            InputField(
                valueState = totalBillState,
                labelID = "Enter Bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!valiedState) return@KeyboardActions

                    //to do
                    onValchange(totalBillState.value.trim())


                    keyboardController?.hide()
                }
            )

//            if (valiedState) {
                Row(
                    modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split", modifier = Modifier.align(
                            alignment = Alignment.CenterVertically
                        )
                    )

                    Spacer(modifier = Modifier.width(120.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundIconButton(
                            imageVector = Icons.Default.Remove,
                            onClick = { /*TODO*/ })

                        Text(text = "3", modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 9.dp, end = 9.dp)
                        )
                        
                        RoundIconButton(
                            imageVector = Icons.Default.Add,
                            onClick = { /*TODO*/ })



                    }

                }
            
            //tip row
            Row(modifier = Modifier.padding(horizontal = 3.dp, vertical = 12.dp)

            ) {
                
                Text(
                    text = "Tip",
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
                
                Spacer(modifier = Modifier.width(200.dp))

                Text(
                    text = "$33.00",
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }
            
            
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(text = "33%")
                
                Spacer(modifier = Modifier.height(14.dp))

                //slider
                Slider(value = sliderPositionState.value, onValueChange = {
                    newVal->
                    sliderPositionState.value=newVal
                }, modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    steps = 5,
                    onValueChangeFinished = {

                    }
                )
            }
//            } else {
//                Box {
//
//                }
//            }

        }
    }
}