package id.ngoprek.testing.arch.utils

import kotlinx.coroutines.Dispatchers

class AppDispatcherProvider : DispatcherProvider {
    override fun main() = Dispatchers.Main
    override fun io() = Dispatchers.IO
}