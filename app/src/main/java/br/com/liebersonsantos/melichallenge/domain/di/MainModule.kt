package br.com.liebersonsantos.melichallenge.domain.di

import br.com.liebersonsantos.melichallenge.common.baseUrl
import br.com.liebersonsantos.melichallenge.data.api.Api
import br.com.liebersonsantos.melichallenge.data.repository.Repository
import br.com.liebersonsantos.melichallenge.data.repository.RepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by lieberson on 9/14/21.
 * @author lieberson.xsantos@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideApi(): Api = Retrofit.Builder()
        .baseUrl(baseUrl())
        .addConverterFactory(GsonConverterFactory.create(provideGson()))
        .client(provideClient())
        .build()
        .create(Api::class.java)

    @Singleton
    @Provides
    fun providesInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(providesInterceptor())
            .build()

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideRepository(api: Api): Repository = RepositoryImpl(api)

}