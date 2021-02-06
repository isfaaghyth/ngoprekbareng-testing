package id.ngoprek.testing.arch.base

import id.ngoprek.testing.arch.data.Fail
import id.ngoprek.testing.arch.data.Result
import id.ngoprek.testing.arch.data.Success
import java.lang.Exception

abstract class UseCase<in P, out R: Any> {

    abstract suspend fun execute(param: P): R

    suspend operator fun invoke(params: P): Result<R> {
        return try {
            Success(execute(params))
        } catch (e: Exception) {
            Fail(e)
        }
    }

}