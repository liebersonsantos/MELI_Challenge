package br.com.liebersonsantos.melichallenge.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @JvmSuppressWildcards
    @Provides
    @Named("main")
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @JvmSuppressWildcards
    @Provides
    @Named("io")
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @JvmSuppressWildcards
    @Provides
    @Named("default")
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @JvmSuppressWildcards
    @Provides
    @Named("unconfined")
    fun provideUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined

}