package id.ngoprek.testing.arch.data.repository

import id.ngoprek.testing.arch.data.entity.Login

interface LoginRepository {
    fun login(username: String, password: String): Login
    fun isLogin(): Boolean
}