package com.example.hiltcopy.data.di

import com.example.hiltcopy.data.usecase.CombineNumberUseCaseImpl
import com.example.hiltcopy.domain.CombineNumberUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindCombineNumberUseCase(uc:CombineNumberUseCaseImpl):CombineNumberUseCase

}