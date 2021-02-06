package id.ngoprek.testing.arch.data

sealed class Result<out T: Any>
data class Success<out T: Any>(val data: T): Result<T>() {
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            data
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = data
}
data class Fail(val throwable: Throwable): Result<Nothing>()