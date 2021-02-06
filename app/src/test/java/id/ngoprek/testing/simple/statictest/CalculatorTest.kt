package id.ngoprek.testing.simple.statictest

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Before fun setUp() {
        mockkObject(Addition)
    }

    @Test fun calc() {
        // Given
        val a = 1
        val b = 2
        val expectedValue = 3

        every { Addition.addition(a, b) } returns expectedValue

        // When
        val actual = calculator.calc(a, b)

        // Then
        assert(actual == expectedValue + 2)
    }

    @Test fun `actual result`() {
        // Given
        val a = 1
        val b = 2
        val expectedValue = 3

        every { Addition.addition(a, b) } returns expectedValue

        // When
        val actual = calculator.calc(a, b)

        // Then
        assert(calculator.result == expectedValue)
    }

}