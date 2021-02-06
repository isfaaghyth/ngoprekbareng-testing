package id.ngoprek.testing.simple.withdeps

import id.ngoprek.testing.simple.withdeps.factory.CalculatorFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class AdvancedCalculatorTest {

    private val factory: CalculatorFactory = mockk()
    private val calculator = AdvancedCalculator(factory)

    @Test fun addition() {
        // Given
        val a = 1
        val b = 2
        val expectedValue = 3

        every { factory.addition(a, b) } returns expectedValue
        every { factory.subtraction(a, b) } returns expectedValue

        // When
        val actual = calculator.addition(a, b)

        // Then
        assert(actual == 6)
    }

}