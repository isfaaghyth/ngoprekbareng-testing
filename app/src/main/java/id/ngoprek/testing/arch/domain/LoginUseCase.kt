package id.ngoprek.testing.arch.domain

import id.ngoprek.testing.arch.base.UseCase
import id.ngoprek.testing.arch.data.mapper.LoginMapper
import id.ngoprek.testing.arch.data.repository.LoginRepository
import id.ngoprek.testing.arch.ui.uimodel.LoginUIModel

class LoginUseCase constructor(
    private val repository: LoginRepository
) : UseCase<Map<String, String>, LoginUIModel>() {

    override suspend fun execute(param: Map<String, String>): LoginUIModel {
        val username = param[PARAM_USERNAME]?: ""
        val password = param[PARAM_PASSWORD]?: ""

        if (username.isEmpty() && password.isEmpty()) throw Exception("username or password not found")

        return LoginMapper.mapTo(repository.login(username, password))
    }

    companion object {
        const val PARAM_USERNAME = "username"
        const val PARAM_PASSWORD = "password"

        fun generateParams(username: String, password: String): Map<String, String> {
            val loginParams = hashMapOf<String, String>()
            loginParams[PARAM_USERNAME] = username
            loginParams[PARAM_PASSWORD] = password
            return loginParams
        }
    }

}