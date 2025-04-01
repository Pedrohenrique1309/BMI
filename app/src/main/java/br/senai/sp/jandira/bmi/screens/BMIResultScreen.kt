package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculator
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFortmat
import java.util.Locale

@Composable

fun BMIResultScreen (navController: NavHostController?){

    val context = LocalContext.current

    val sharedUserFile = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val age    = sharedUserFile.getInt("user_age"   , 0)
    val height: Double = sharedUserFile.getInt("user_height", 0).toDouble()
    val weight = sharedUserFile.getInt("user_weight", 0)

    val bmiResult = bmiCalculator(weight,height)

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
            modifier =  Modifier
                .padding(bottom = 800.dp),

        ){
            Text(
                stringResource(R.string.your_bmi_result),
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
                topStart = 32.dp,
                topEnd = 32.dp
            ),
            colors = CardDefaults.cardColors(
                Color.White
            )
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(190.dp)
                    .width(260.dp)
                    .padding(top = 30.dp, start = 110.dp)
            ){
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                    shape = RoundedCornerShape(
                        topEnd = 90.dp,
                        topStart = 90.dp,
                        bottomEnd = 90.dp,
                        bottomStart = 90.dp
                    ),
                    border = BorderStroke(
                        width = 10.dp,
                        color = bmiResult.color
                    ),
                    colors = CardDefaults.cardColors(
                        Color.White
                    ),
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(top = 40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = String.format(
                                Locale.getDefault(),
                                format = "%.1f" ,
                                bmiResult.bmi.second),
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 80.dp)
            ){
                Text(
                    text = String.format(
                        bmiResult.bmi.first
                    ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Card(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(80.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(10.dp)
                        ){
                            Text(
                                text = stringResource(R.string.age),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(start = 15.dp)
                        ){
                            Text(
                                text = age.toString(),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                    VerticalDivider(
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(100.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(10.dp)
                        ){
                            Text(
                                stringResource(R.string.weight),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(start = 15.dp)
                        ){
                            Text(
                                text = "$weight Kg",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                    VerticalDivider(
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(110.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(10.dp)
                        ){
                            Text(
                                stringResource(R.string.hight),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(start = 10.dp)
                        ){
                            Text(
                                text = "${String.format(Locale.getDefault(),"%.2f", height)} cm" ,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                }
            }

            //Mostar o resultado do IMC
            BmiLevel(
                markColor = colorResource(R.color.light_blue),
                text1 = stringResource(R.string.under_weight_table),
                text2 = "<  ${numberFortmat(18.5)}",
                isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.UNDERWEIGHT)
            )
            BmiLevel(
                markColor = colorResource(R.color.light_green),
                text1 = stringResource(R.string.normal_weight_table),
                text2 = "${numberFortmat(18.6)}  -  ${numberFortmat(24.9)}",
                isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.NORMAL)
            )
            BmiLevel(
                markColor = colorResource(R.color.yellow),
                text1 = stringResource(R.string.over_weight_table),
                text2 = "${numberFortmat(25.0)}  -  ${numberFortmat(29.9)}",
                isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OVERWEIGHT)
            )
            BmiLevel(
                markColor = colorResource(R.color.light_orange),
                text1 = stringResource(R.string.obesity1),
                text2 = "${numberFortmat(30.0)}  -  ${numberFortmat(34.9)}",
                isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY1)
            )
            BmiLevel(
                markColor = colorResource(R.color.dark_orange),
                text1 = stringResource(R.string.obesity2),
                text2 = "${numberFortmat(35.0)}  -  ${numberFortmat(39.9)}",
                isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY2)
            )
            BmiLevel(
                markColor = colorResource(R.color.red),
                text1 = stringResource(R.string.obesity3),
                text2 = ">  ${numberFortmat(39.9)}",
                isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY3)
            )




            HorizontalDivider(
                modifier = Modifier
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 20.dp,
                        top = 20.dp)
            )
            Button(
                onClick = {
                    navController?.navigate("user_data")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF3F7FE1))
            ) {
                Text(
                    stringResource(R.string.new_calc),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }
        }
    }

}

@Preview (showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}
