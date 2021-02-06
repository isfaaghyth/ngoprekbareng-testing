package id.ngoprek.testing.simple.static

object Addition {
    fun addition(a: Int, b: Int): Int {
        return a + b
    }
}

class Calculator {

    fun calc(a: Int, b: Int): Int {
        return Addition.addition(a, b)
    }

}