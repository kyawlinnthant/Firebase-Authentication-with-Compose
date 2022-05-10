package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupAction
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupEvent
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupState
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {
    private val _signupState = mutableStateOf(SignupState())
    val signupState: State<SignupState> get() = _signupState
    private val _signupEvent = MutableSharedFlow<SignupEvent>()
    val signupEvent: SharedFlow<SignupEvent> get() = _signupEvent

    fun onAction(action: SignupAction) {
        when (action) {
            is SignupAction.ChangeConfirmPassword -> {

            }
            is SignupAction.ChangePassword -> {

            }
            is SignupAction.ChangeUsername -> {

            }
            SignupAction.ClickLogin -> {

            }
            SignupAction.ClickRegister -> {

            }
        }
    }

    private fun validate(){

    }
}