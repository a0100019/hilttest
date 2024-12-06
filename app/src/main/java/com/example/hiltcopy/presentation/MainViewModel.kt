package com.example.hiltcopy.presentation

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.example.hiltcopy.domain.CombineNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val combineNumberUseCase: CombineNumberUseCase
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

    //reduce는 상태를 가져오고 변경한 상태를 업데이트하기위한 함수
    //state.copy는 data class의 기능으로 일부 값을 변경한 새로운 상태를 반환
    @OptIn(OrbitExperimental::class)
    fun onSecondNumberChange(secondNumber: String) = blockingIntent {
        reduce {
            state.copy(secondNumber = secondNumber)
        }

    }

    // 버튼 클릭 시 두 숫자 합치기
    fun onCombineNumbers() = intent {
        val combinedValue = combineNumberUseCase(state.firstNumber, state.secondNumber)
        reduce {
            state.copy(result = combinedValue) // 결과를 상태에 저장
        }
    }

}

//뷰모델에서 관리할 텍스트들
@Immutable
data class MainState(
    val firstNumber:String = "",
    val secondNumber:String = "",
    val result:String = ""
)

//상태와 관련없는 것
sealed interface MainSideEffect{
    class Toast(val message:String):MainSideEffect
//    object NavigateToMainActivity:MainSideEffect
}