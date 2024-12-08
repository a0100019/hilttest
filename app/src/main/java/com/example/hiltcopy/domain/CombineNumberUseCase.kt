package com.example.hiltcopy.domain

interface CombineNumberUseCase {

    suspend operator fun invoke(
        firstNumber: String,
        secondNumber: String,
        operation: String
    ):String

}
