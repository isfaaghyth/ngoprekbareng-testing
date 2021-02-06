package id.ngoprek.testing.simple.withdeps.factory

import id.ngoprek.testing.simple.withdeps.operator.Addition
import id.ngoprek.testing.simple.withdeps.operator.Subtraction

class CalculatorFactory : Addition, Subtraction {

    override fun addition(a: Int, b: Int): Int {
        return a + b
    }

    override fun subtraction(a: Int, b: Int): Int {
        return a - b
    }

}