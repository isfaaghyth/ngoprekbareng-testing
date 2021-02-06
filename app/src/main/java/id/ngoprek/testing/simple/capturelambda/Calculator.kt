package id.ngoprek.testing.simple.capturelambda

class CalculatorLambda constructor(
    private val a: Int,
    private val b: Int
) {
    fun addition(
        onSuccess: (Int) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        try {
            onSuccess(a + b)
        } catch (e: Exception) {
            onError(Throwable("duh!"))
        }
    }
}

class Calculator constructor(
    private val calc: CalculatorLambda
) {

    var result = 0
    lateinit var onError: Throwable

    fun calculator() {
        calc.addition({
            result = it
        }, {
            onError = it
        })
    }

}