package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun TelaInicial(navController: NavHostController?) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var errorMessage = remember{
        mutableStateOf("")
    }

    var context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(
                listOf(
                    Color(0xFF3F7FE1),
                    Color(0xFF0047F6)

                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.logoDescription),
                modifier = Modifier
                    .padding(top = 32.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 48.sp,
                color = Color.White
            )
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                )
            ){
                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ){
                    Column {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 20.sp
                        )
                        OutlinedTextField(

                            value = nomeState.value,

                            onValueChange = {
                                nomeState.value = it
                            },

                            label = { Text (text = stringResource(R.string.your_name_here)) },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),

                            shape = RoundedCornerShape(15.dp),

                            leadingIcon = {

                                Icon(
                                    imageVector = Icons.Default.AccountBox,
                                    contentDescription = "",
                                    tint = Color(0xFF0047F6)
                                )

                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Done
                            ),

                            isError = isErrorState.value,
                            supportingText = {
                                Text(
                                    text = errorMessage.value,
                                    color = Color.Red
                                )
                            },

                                colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Blue,
                                cursorColor = Color.Blue,
                                unfocusedBorderColor = Color(0xFF3F7FE1)

                            ),

                        )
                    }
                    Button(

                        onClick = {

                            if(nomeState.value.length < 3){
                                isErrorState.value = true
                                errorMessage.value = context.getString(R.string.support_name)
                            }else{
                                navController?.navigate("user_data")
                            }

                        },

                        colors =  ButtonDefaults.buttonColors(Color(0xFF0047F6))
                    ) {

                        Text(

                            text = stringResource(R.string.next)

                        )

                        Icon(

                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Next"

                        )
                    }
                }
                
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    TelaInicial(null)
}