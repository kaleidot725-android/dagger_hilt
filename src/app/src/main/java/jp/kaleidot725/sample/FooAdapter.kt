package jp.kaleidot725.sample

import javax.inject.Inject

class FooAdapter @Inject constructor(
    private val service: FooService
) {
    fun bar() {
        service.bar()
    }
}
