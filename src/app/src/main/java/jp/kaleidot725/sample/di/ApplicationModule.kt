package jp.kaleidot725.sample.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jp.kaleidot725.sample.model.FooService
import jp.kaleidot725.sample.model.FooServiceImpl
import jp.kaleidot725.sample.model.FooUsecase

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApplicationBindsModule {
    @Binds
    abstract fun bindFooService(fooServiceImpl: FooServiceImpl) : FooService
}

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationProvidesModule {
    @Provides
    fun provideFooUseCase(fooService: FooService) : FooUsecase {
        return FooUsecase(fooService)
    }
}
