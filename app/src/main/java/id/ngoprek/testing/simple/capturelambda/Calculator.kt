package id.ngoprek.testing.simple.capturelambda

class Calculator constructor(
    private val a: Int,
    private val b: Int
) {

    fun calculator(
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