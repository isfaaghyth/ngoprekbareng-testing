package id.ngoprek.testing.arch.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
}