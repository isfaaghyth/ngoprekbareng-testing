package id.ngoprek.testing.simple.withoutdeps

import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test fun addition() {
        // Given
        val a = 1
        val b = 2
        val expectedValue = 3

        // When
        val actual = calculator.addition(a, b)

        // Then
        assert(actual == expectedValue)
    }

    @Test fun subtraction() {
        // Given
        val a = 2
        val b = 1
        val expectedValue = 1

        // When
        val actual = calculator.subtraction(a, b)

        // Then
        assert(actual == expectedValue)
    }

    @Test fun division() {
        // Given
        val a = 2
        val b = 2
        val expectedValue = 1

        // When
        val actual = calculator.division(a, b)

        // Then
        assert(actual == expectedValue)
    }

    @Test fun multiple() {
        // Given
        val a = 2
        val b = 2
        val expectedValue = 4

        // When
        val actual = calculator.multiple(a, b)

        // Then
        assert(actual == expectedValue)
    }

}