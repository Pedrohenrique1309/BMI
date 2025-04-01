package br.senai.sp.jandira.bmi.utils

import androidx.compose.runtime.Composable
import br.senai.sp.jandira.bmi.model.BmiStatus
import java.util.Locale

@Composable
fun numberFortmat(number: Double) =

    String.format(
        Locale.getDefault(),
        "%.1f",
        number
    )

@Composable
fun isFilled (userStatus: BmiStatus, status: BmiStatus) =

    if (userStatus == status)true
    else
        false