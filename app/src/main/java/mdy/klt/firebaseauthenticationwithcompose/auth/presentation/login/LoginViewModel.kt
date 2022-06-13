package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import mdy.klt.firebaseauthenticationwithcompose.auth.domain.usecase.LoginValidate
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginAction
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginEvent
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val validator: LoginValidate
) : ViewModel() {
    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> get() = _loginState
    private val _loginEvent = MutableSharedFlow<LoginEvent>()
    val loginEvent: SharedFlow<LoginEvent> get() = _loginEvent

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.ChangeEmail -> {
                _loginState.value = loginState.value.copy(
                    form = loginState.value.form.copy(
                        email = action.email
                    )
                )
            }
            is LoginAction.ChangePassword -> {
                _loginState.value = loginState.value.copy(
                    form = loginState.value.form.copy(
                        password = action.password
                    )
                )
            }
            LoginAction.ClickLogin -> {
                validate()
            }
            LoginAction.ClickPassword -> {
                viewModelScope.launch {
                    _loginEvent.emit(
                        LoginEvent.NavigateToPassword
                    )
                }
            }
            LoginAction.ClickSignup -> {
                viewModelScope.launch {
                    _loginEvent.emit(
                        LoginEvent.NavigateToSignup
                    )
                }
            }
        }
    }

    private fun validate() {
        validator(
            form = loginState.value.form
        ).apply {
            _loginState.value = loginState.value.copy(
                error = this
            )
        }.also {
            if (!it.emailError && !it.passwordError) {
                login()
            }
        }
    }


    private fun login() {
        viewModelScope.launch {
            firebaseAuth.signInWithEmailAndPassword(
                loginState.value.form.email,
                loginState.value.form.password
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    viewModelScope.launch {
                        _loginEvent.emit(LoginEvent.NavigateToHome)
                    }
                    return@addOnCompleteListener
                }
                viewModelScope.launch {
                    _loginEvent.emit(LoginEvent.ShowSnack(message = "Can't login!"))

                }
            }
        }
    }
}