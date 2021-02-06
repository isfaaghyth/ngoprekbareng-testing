package id.ngoprek.testing.arch.data.mapper

import id.ngoprek.testing.arch.data.entity.Login
import id.ngoprek.testing.arch.data.entity.LoginData
import id.ngoprek.testing.arch.ui.uimodel.LoginUIModel

object LoginMapper {

    fun mapTo(login: Login): LoginUIModel {
        val loginData = login.data?: LoginData()
        return LoginUIModel(
            id = loginData.id,
            name = loginData.name,
            username = loginData.username,
            email = loginData.email
        )
    }

}