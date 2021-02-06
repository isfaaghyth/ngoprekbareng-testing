package id.ngoprek.testing.simple.capturelambda

import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class CalculatorTest {

    private val calcLambda: CalculatorLambda = mockk()
    private val calculator = Calculator(calcLambda)

    @Test fun onSuccess() {
        // Given
        val expectedValue = 3

        every {
            calcLambda.addition(captureLambda(), any())
        } answers {
            val onSuccess = lambda<(Int) -> Unit>()
            onSuccess.invoke(expectedValue)
        }

        // When
        calculator.calculator()

        // Then
        assert(calculator.result == expectedValue)
    }

    @Test fun onError() {
        // Given
        val expectedValue = Throwable("")

        every {
            calcLambda.addition(any(), captureLambda())
        } answers {
            val onSuccess = lambda<(Throwable) -> Unit>()
            onSuccess.invoke(expectedValue)
        }

        // When
        calculator.calculator()

        // Then
        assert(calculator.onError == expectedValue)
    }

}