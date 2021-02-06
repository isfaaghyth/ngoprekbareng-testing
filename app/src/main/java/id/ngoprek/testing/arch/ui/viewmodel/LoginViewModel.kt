package id.ngoprek.testing.arch.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ngoprek.testing.arch.data.Result
import id.ngoprek.testing.arch.domain.LoginUseCase
import id.ngoprek.testing.arch.ui.uimodel.LoginUIModel
import id.ngoprek.testing.arch.utils.DispatcherProvider
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel constructor(
    private val loginUseCase: LoginUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    private val _login = MutableLiveData<Result<LoginUIModel>>()
    val login: LiveData<Result<LoginUIModel>> get() = _login

    fun doLogin(username: String, password: String) {
        val param = LoginUseCase.generateParams(username, password)
        viewModelScope.launch(dispatcher.io()) {
            val result = loginUseCase(param)
            withContext(dispatcher.main()) {
                _login.value = result
            }
        }
    }

}