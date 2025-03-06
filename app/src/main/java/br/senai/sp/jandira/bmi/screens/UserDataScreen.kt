package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R
import java.util.ResourceBundle

@Composable

fun UserDataScreen (modifier: Modifier= Modifier){

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
               .padding()
               .padding(bottom = 750.dp)
       ){
           Text(
               stringResource(R.string.hi),
               fontSize = 30.sp,
               fontWeight = FontWeight.Bold
           )
       }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp),

        ) {
            Column (
            ){
                Row (

                ){
                    Column(

                    ) {

                    }
                    Column(

                    ){

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