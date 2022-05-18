package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import mdy.klt.firebaseauthenticationwithcompose.auth.domain.usecase.SignupValidate
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupAction
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupEvent
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupState
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val validator : SignupValidate

) : ViewModel() {
    private val _signupState = mutableStateOf(SignupState())
    val signupState: State<SignupState> get() = _signupState
    private val _signupEvent = MutableSharedFlow<SignupEvent>()
    val signupEvent: SharedFlow<SignupEvent> get() = _signupEvent

    fun onAction(action: SignupAction) {
        when (action) {
            is SignupAction.ChangeConfirmPassword -> {
                _signupState.value = signupState.value.copy(
                    form = signupState.value.form.copy(
                        confirmPassword = action.confirmPassword
                    ),
                    error = signupState.value.error.copy(
                        confirmPasswordError = false
                    )
                )
            }
            is SignupAction.ChangePassword -> {
                _signupState.value = signupState.value.copy(
                    form = signupState.value.form.copy(
                        password = action.password
                    ),
                    error = signupState.value.error.copy(
                        passwordError = false
                    )
                )
            }
            is SignupAction.ChangeEmail -> {
                _signupState.value = signupState.value.copy(
                    form = signupState.value.form.copy(
                        email = action.email
                    ),
                    error = signupState.value.error.copy(
                        emailError = false
                    )
                )
            }
            SignupAction.ClickLogin -> {
                viewModelScope.launch {
                    _signupEvent.emit(SignupEvent.NavigateToLogin)
                }
            }
            SignupAction.ClickRegister -> {
                validate()
            }
        }
    }

    private fun validate(){
        validator(
            form = signupState.value.form
        ).apply {
            _signupState.value = signupState.value.copy(
                error = this
            )
        }.also {
            if (!it.emailError && !it.passwordError && !it.confirmPasswordError){
                viewModelScope.launch {
                    _signupEvent.emit(SignupEvent.ShowSnack(message = "Success Validation"))
                }
            }
        }
    }

    private fun signup() {
       /* viewModelScope.launch {
            firebaseAuth.createUserWithEmailAndPassword(
                "email","password"
            ).addOnCompleteListener {
                //todo : check successful or not
            }
        }*/
    }
}