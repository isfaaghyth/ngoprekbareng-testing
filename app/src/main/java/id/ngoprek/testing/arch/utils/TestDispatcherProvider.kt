package id.ngoprek.testing.arch.utils

import kotlinx.coroutines.Dispatchers

class TestDispatcherProvider : DispatcherProvider {
    override fun main() = Dispatchers.Unconfined
    override fun io() = Dispatchers.Unconfined
}