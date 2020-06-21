package jp.kaleidot725.sample

import android.util.Log
import javax.inject.Inject

class FooServiceImpl @Inject constructor(): FooService {
    override fun bar() {
        Log.v("TAG", "bar")
    }
}
