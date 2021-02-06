package id.ngoprek.testing.simple.withdeps

import id.ngoprek.testing.simple.withdeps.factory.CalculatorFactory
import id.ngoprek.testing.simple.withdeps.operator.Addition
import id.ngoprek.testing.simple.withdeps.operator.Subtraction

class AdvancedCalculator(
    private val factory: CalculatorFactory
) : Addition, Subtraction {

    override fun addition(a: Int, b: Int): Int {
        val addition = factory.addition(a, b)
        val subtraction = factory.subtraction(a, b)
        return addition + subtraction
    }

    override fun subtraction(a: Int, b: Int): Int {
        return factory.subtraction(a, b)
    }

}