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
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupAction
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupEvent
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupState
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {
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

    private fun signup() {
        viewModelScope.launch {
            firebaseAuth.createUserWithEmailAndPassword(
                "email","password"
            ).addOnCompleteListener {
                //todo : check successful or not
            }
        }
    }
}