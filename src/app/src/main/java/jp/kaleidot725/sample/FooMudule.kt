package jp.kaleidot725.sample

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class FooBindsModule {
    @Binds
    abstract fun bindFooService(fooServiceImpl: FooServiceImpl) : FooService
}

@Module
@InstallIn(ActivityComponent::class)
object FooProvidesModule {
    @Provides
    fun provideFooAdapter(fooService: FooService) : FooAdapter {
        return FooAdapter(fooService)
    }
}
