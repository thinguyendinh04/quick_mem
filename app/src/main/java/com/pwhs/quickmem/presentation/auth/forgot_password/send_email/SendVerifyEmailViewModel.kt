package com.pwhs.quickmem.presentation.auth.forgot_password.send_email

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.pwhs.quickmem.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SendVerifyEmailViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(SendVerifyEmailUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<SendVerifyEmailUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SendVerifyEmailUiAction) {
        when (event) {
            is SendVerifyEmailUiAction.EmailChangedAction -> {
                _uiState.update {
                    it.copy(
                        email = event.email,
                        emailError = if (android.util.Patterns.EMAIL_ADDRESS.matcher(event.email)
                                .matches()
                        ) ""
                        else "Invalid email address"
                    )
                }
            }

            is SendVerifyEmailUiAction.ResetPassword -> {
                if (validateInput()) {
                    resetPassword()
                } else {
                    Toast.makeText(getApplication(), "Invalid input", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validateInput(): Boolean {
        val emailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(uiState.value.email).matches()
        _uiState.update { it.copy(emailError = if (emailValid) "" else "Invalid email address") }
        return emailValid
    }

    private fun resetPassword() {
        _uiEvent.trySend(SendVerifyEmailUiEvent.SendEmailSuccess)
    }

    override fun onCleared() {
        super.onCleared()
        _uiEvent.close()
    }
}
