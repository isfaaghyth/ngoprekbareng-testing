package id.ngoprek.testing.arch.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import id.ngoprek.testing.arch.data.Result
import id.ngoprek.testing.arch.data.Success
import id.ngoprek.testing.arch.domain.LoginUseCase
import id.ngoprek.testing.arch.ui.uimodel.LoginUIModel
import id.ngoprek.testing.arch.utils.TestDispatcherProvider
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @get:Rule val instantExecutorRule = InstantTaskExecutorRule()

    private val useCase: LoginUseCase = mockk()
    private val dispatcher = TestDispatcherProvider()
    private val viewModel = LoginViewModel(useCase, dispatcher)

    private val loginObserver: Observer<Result<LoginUIModel>> = spyk()

    @Before fun setUp() {
        viewModel.login.observeForever(loginObserver)
    }

    @Test fun `it should login correctly`() {
        // Given
        val expectedValue = Success(
            LoginUIModel("", "isfa", "", "")
        )

        coEvery { useCase(any()) } returns expectedValue

        // When
        viewModel.doLogin("", "")

        // Then
        assert(viewModel.login.value == expectedValue)
    }

}