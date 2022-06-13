package mdy.klt.firebaseauthenticationwithcompose.app.navigation

sealed class Navigator(route: String){
    object Login : Navigator(route = Destinations.LOGIN)
    object Signup : Navigator(route = Destinations.SIGNUP)
    object ForgotPassword : Navigator(route = Destinations.FORGOT_PASSWORD)
    object Home : Navigator(route = Destinations.HOME)
}
