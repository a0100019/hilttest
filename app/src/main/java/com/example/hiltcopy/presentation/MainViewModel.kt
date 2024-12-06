package com.example.hiltcopy.presentation

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> = container(
        initialState = MainState()
    )

    //아이디 입력 가능하게 하는 코드
    @OptIn(OrbitExperimental::class)
    fun onFirstNumberChange(firstNumber: String) = blockingIntent {
        reduce {
            state.copy(firstNumber = firstNumber)
        }

    }

    @OptIn(OrbitExperimental::class)
    fun onSecondNumberChange(secondNumber: String) = blockingIntent {
        reduce {
            state.copy(secondNumber = secondNumber)
        }

    }

}



@Immutable
data class MainState(
    val firstNumber:String = "",
    val secondNumber:String = ""
)

//상태와 관련없는 것
sealed interface MainSideEffect{
    class Toast(val message:String):MainSideEffect
//    object NavigateToMainActivity:MainSideEffect
}