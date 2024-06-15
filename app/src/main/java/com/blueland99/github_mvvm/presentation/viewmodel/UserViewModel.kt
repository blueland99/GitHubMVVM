package com.blueland99.github_mvvm.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueland99.github_mvvm.domain.model.User
import com.blueland99.github_mvvm.domain.usecase.GetUsersUseCase
import com.blueland99.github_mvvm.util.extractErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val TAG = javaClass.name

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    // 오류 메세지를 담을 LiveData
    private val _errorLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun loadUsers() {
        viewModelScope.launch {
            val response = getUsersUseCase.execute(query = "blueland")
            if (response.isSuccessful) {
                _users.value = response.body()?.items
            } else {
                val errorMessage = extractErrorMessage(response)
                _errorLiveData.value = errorMessage
                Log.e(TAG, "loadUsers: $errorMessage")
            }
        }
    }
}
