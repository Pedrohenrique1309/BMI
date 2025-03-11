package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R
import java.util.ResourceBundle

@Composable

fun UserDataScreen (modifier: Modifier= Modifier){

    var ageState = remember {
        mutableStateOf(value = "")
    }

    var weightState = remember {
        mutableStateOf(value = "")
    }

    var heightState = remember {
        mutableStateOf(value = "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF3F7FE1),
                        Color(0xFF0047F6)

                    )
                )
            ),
        contentAlignment = Alignment.BottomStart
    ){
       Row (
           horizontalArrangement = Arrangement.Start,
           verticalAlignment = Alignment.Top,
           modifier = Modifier
               .padding(bottom = 800.dp)
               .padding(start = 10.dp)
       ){
           Text(
               stringResource(R.string.hi),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
               color = Color.White

               )
       }
        Card(
            modifier = Modifier
                .height(750.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                topEnd = 32.dp,
                topStart = 32.dp
            ),
            colors = CardDefaults.cardColors(
                contentColor = Color.White
            )

        ) {
            Row (
                modifier = Modifier
                    .height(250.dp)
                    .width(350.dp)
                    .padding(top = 70.dp, start = 90.dp)
            ){
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(100.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp),
                        shape = RoundedCornerShape(
                            topEnd = 60.dp,
                            topStart = 60.dp,
                            bottomEnd = 60.dp,
                            bottomStart = 60.dp
                        ),
                        border = BorderStroke(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF3F7FE1),
                                    Color(0xFF0047F6)
                                )
                            )
                        )
                    ) {
                        Image(
                            painter = painterResource(R.drawable.men),
                            contentDescription = ""
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        colors =  ButtonDefaults.buttonColors(Color(0xFF3F7FE1))
                    ) {
                        Text(
                            stringResource(R.string.male)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 50.dp)
                        .height(200.dp)
                        .width(100.dp)
                ){
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp),
                        shape = RoundedCornerShape(
                            topEnd = 60.dp,
                            topStart = 60.dp,
                            bottomEnd = 60.dp,
                            bottomStart = 60.dp
                        ),
                        border = BorderStroke(
                                width = 2.dp,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF3F7FE1),
                                        Color(0xFF0047F6)
                                    )
                                )
                            )
                        ) {
                        Image(
                            painter = painterResource(R.drawable.woman),
                            contentDescription = ""
                        )

                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        colors =  ButtonDefaults.buttonColors(Color(0xFF3F7FE1)),

                    ) {
                        Text(
                            stringResource(R.string.female)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            )
            {
                OutlinedTextField(
                    value = ageState.value,
                    onValueChange = {
                        ageState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    shape = RoundedCornerShape(15.dp),
                    label = { Text(text = stringResource(R.string.age))},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Numbers,
                            contentDescription = "",
                            tint = Color(0xFF0047F6)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Blue,
                        cursorColor = Color.Blue,
                        unfocusedBorderColor = Color(0xFF3F7FE1)

                    ),
                    textStyle = TextStyle(
                        fontSize = 24.sp
                    )


                )

                OutlinedTextField(
                    value = weightState.value,
                    onValueChange = {
                        weightState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    shape = RoundedCornerShape(15.dp),
                    label = { Text(text = stringResource(R.string.weight))},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Balance,
                            contentDescription = "",
                            tint = Color(0xFF0047F6)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Blue,
                        cursorColor = Color.Blue,
                        unfocusedBorderColor = Color(0xFF3F7FE1)
                    ),
                    textStyle = TextStyle(
                        fontSize = 24.sp
                    )

                )

                OutlinedTextField(
                    value = heightState.value,
                    onValueChange = {
                        heightState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    shape = RoundedCornerShape(15.dp),
                    label = { Text(text = stringResource(R.string.height))},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Height,
                            contentDescription = "",
                            tint = Color(0xFF0047F6)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Blue,
                        cursorColor = Color.Blue,
                        unfocusedBorderColor = Color(0xFF3F7FE1)
                    ),
                    textStyle = TextStyle(
                        fontSize = 24.sp
                    )

                )

                Row (
                    modifier = Modifier
                        .padding(top = 100.dp, start = 30.dp)
                ){
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .width(370.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                      colors =  ButtonDefaults.buttonColors(Color(0xFF0047F6))

                    ) {
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 25.sp
                        )
                    }
                }

            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen()
}