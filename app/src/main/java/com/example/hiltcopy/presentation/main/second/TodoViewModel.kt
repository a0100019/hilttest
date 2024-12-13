package com.example.hiltcopy.presentation.main.second

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltcopy.data.room.Todo
import com.example.hiltcopy.data.room.TodoDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoDao: TodoDao
) : ViewModel(), ContainerHost<TodoState, Nothing> { // SideEffect를 Nothing으로 지정, 사이드 안 쓸 때!!

    override val container: Container<TodoState, Nothing> =
        container(
            initialState = TodoState()
        )

    // 초기화 시 모든 Todo 데이터를 로드
    init {
        loadTodos()
    }

    //room에서 데이터 가져옴
    private fun loadTodos() = intent {
        // Flow 데이터를 State로 업데이트
        todoDao.getAllTodos().collect { todos ->
            reduce {
                state.copy(todoList = todos)
            }
        }
    }

    fun addTodo() = intent {
        val newTodo = Todo(title = state.todoText)
        todoDao.insert(newTodo)
        // 새로 추가된 Todo를 State에 반영
        reduce {
            state.copy(todoList = state.todoList + newTodo)
        }
    }

    //아이디 입력 가능하게 하는 코드
    @OptIn(OrbitExperimental::class)
    fun onTodoTextChange(todoText: String) = blockingIntent {
        reduce {
            state.copy(todoText = todoText)
        }
    }


//    fun removeTodo(todo: Todo) = intent {
//        todoDao.delete(todo)
//        reduce {
//            state.copy(todoList = state.todoList - todo)
//        }
//        postSideEffect(TodoSideEffect.Toast("Todo 삭제 완료!"))
//    }
}

// ViewModel에서 관리할 상태
@Immutable
data class TodoState(
    val todoText: String = "",
    val todoList: List<Todo> = emptyList()
)

// 단발성 이벤트 정의
sealed interface TodoSideEffect {
    data class Toast(val message: String) : TodoSideEffect
}
