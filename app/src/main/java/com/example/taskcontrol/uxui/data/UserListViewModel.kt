package com.example.taskcontrol.uxui.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserListViewModel(private val repository: UserListDummy = UserListDummy): ViewModel() {
    private val filter = MutableStateFlow<String?>(null)
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState


    data class UiState(val users: List<User> = UserListDummy.Users)

    fun addUser(user: User){
        repository.addUser(user)
        updateUiState()
    }

    fun verifyUser(email: String, password: String): Boolean{
        val user = User(email, password, "", "")
        return repository.verifyUser(user.email, user.password)
    }

    private fun updateUiState(){
        val usersListSaved = repository.Users
        _uiState.value = UiState(
            users = usersListSaved
        )
    }
}
