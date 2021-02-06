package id.ngoprek.testing.arch.data.repository

import id.ngoprek.testing.arch.data.entity.Login

class LoginRepositoryImpl(
    private val loginResult: Login,
    private val loginState: Boolean
) : LoginRepository {

    override fun login(username: String, password: String): Login {
        return loginResult
    }

    override fun isLogin(): Boolean {
        return loginState
    }

}