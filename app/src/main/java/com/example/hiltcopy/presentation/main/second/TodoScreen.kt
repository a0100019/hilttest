@file:Suppress("UNUSED_EXPRESSION")

package com.example.hiltcopy.presentation.main.second

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hiltcopy.data.room.Todo
import com.example.hiltcopy.ui.theme.HiltCopyTheme
import org.orbitmvi.orbit.compose.collectAsState


@Composable
fun TodoScreen(
    viewModel: TodoViewModel = hiltViewModel()
) {

    //state 이용
    val state : TodoState = viewModel.collectAsState().value

    TodoScreen(
        todoText = state.todoText,
        onTodoTextChange = viewModel::onTodoTextChange,
        onAddTodoButtonClick = viewModel::addTodo,
        todoList = state.todoList
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(
    todoText: String,
    onTodoTextChange: (String) -> Unit,
    onAddTodoButtonClick: () -> Unit,
    todoList: List<Todo>
) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(
                value = todoText,
                onValueChange = onTodoTextChange,
                modifier = Modifier.weight(1f).padding(8.dp)
            )
            Button(onClick = {
                onAddTodoButtonClick
                // todoText 지우는 거 추가

            }) {
                Text("Add")
            }
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(todoList) { todo ->
                Text(text = todo.title, modifier = Modifier.padding(8.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    HiltCopyTheme {
        TodoScreen(
            todoText = "안녕",
            onTodoTextChange = {},
            onAddTodoButtonClick = {},
            todoList = listOf(
                Todo(title = "first"),
                Todo(title = "second"),
                Todo(title = "third")
            )
        )
    }
}