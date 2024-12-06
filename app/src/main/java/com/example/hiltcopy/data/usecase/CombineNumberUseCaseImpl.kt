package com.example.hiltcopy.data.usecase

import com.example.hiltcopy.domain.CombineNumberUseCase
import javax.inject.Inject

class CombineNumberUseCaseImpl @Inject constructor(

) : CombineNumberUseCase {
    override suspend fun invoke(firstNumber: String, secondNumber: String): String {
        val intFirstNumber = firstNumber.toInt()
        val intSecondNumber = secondNumber.toInt()
        val result = intFirstNumber + intSecondNumber
        return result.toString()
    }
}