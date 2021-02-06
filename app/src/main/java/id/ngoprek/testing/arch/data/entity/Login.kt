package id.ngoprek.testing.arch.data.entity

data class Login(
    val success: Boolean = false,
    val data: LoginData? = null
)

data class LoginData(
    val id: String = "",
    val username: String = "",
    val name: String = "",
    val email: String = ""
)