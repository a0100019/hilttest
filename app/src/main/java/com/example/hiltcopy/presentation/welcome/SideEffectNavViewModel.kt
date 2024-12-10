package com.example.hiltcopy.presentation.welcome

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.annotation.concurrent.Immutable
import javax.inject.Inject


@HiltViewModel
class SideEffectNavViewModel @Inject constructor(
) : ViewModel(), ContainerHost<SideEffectNavState, SideEffectNavSideEffect> {

    //아래의 부분이 꼭 있어야하는지 확인!!!!!!!!!
    override val container: Container<SideEffectNavState, SideEffectNavSideEffect> = container(
        initialState = SideEffectNavState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent { postSideEffect(SideEffectNavSideEffect.Toast(throwable.message.orEmpty())) }
            }
        }
    )


// 화면전환 할지 말지 정하는 코드 작성!!!!!!!!
    fun onSignUpClick() = intent{
//        if(state.password != state.repeatPassword){
//            postSideEffect(SignUpSideEffect.Toast(message = "두 패스워드가 일치하지 않습니다."))
//            return@intent
//        }
//        val isSuccessful = signUpUseCase(
//            id = state.id,
//            username = state.username,
//            password = state.password
//        ).getOrThrow()

//        if(isSuccessful){
//            postSideEffect(SideEffectNavSideEffect.NavigateToSelectScreen)
//        }
    }
}

@Immutable
data class SideEffectNavState(
    val id: String = "",
    val username: String = "",
    val password: String = "",
    val repeatPassword: String = "",
)

sealed interface SideEffectNavSideEffect {
    class Toast(val message: String) : SideEffectNavSideEffect

    object NavigateToSelectScreen : SideEffectNavSideEffect
}