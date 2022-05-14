package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel(){


    private fun login() {
        viewModelScope.launch {
            firebaseAuth.signInWithEmailAndPassword(
                "email",
                "password"
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    //todo : successful logic
                }else{
                    //todo : do not successful logic
                }
            }
        }
    }
}