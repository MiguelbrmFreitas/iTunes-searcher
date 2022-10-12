package com.miguelbrmfreitas.data.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.miguelbrmfreitas.data.remote.ItunesSearcherRepositoryImpl
import com.miguelbrmfreitas.data.remote.ItunesSearcherService
import com.miguelbrmfreitas.domain.repository.ItunesSearcherRepository
import com.miguelbrmfreitas.domain.usecases.GetResultsUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L
private const val BASE_URL = "https://itunes.apple.com/"

val networkModule = module {
    single { createService(get()) }

    single { createRetrofit(get(), BASE_URL) }

    single { createOkHttpClient(get()) }

    single { createLoggingInterceptor() }

}

fun createLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

fun createOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    val moshi by lazy {
        val moshiBuilder = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
        moshiBuilder.build()
    }


    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(ScalarsConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

fun createService(retrofit: Retrofit): ItunesSearcherService {
    return retrofit.create(ItunesSearcherService::class.java)
}

fun createItunesRepository(ItunesService: ItunesSearcherService): ItunesSearcherRepository {
    return ItunesSearcherRepositoryImpl(ItunesService)
}

fun createGetUsersUseCase(ItunesRepository: ItunesSearcherRepository): GetResultsUseCase {
    return GetResultsUseCase(ItunesRepository)
}
