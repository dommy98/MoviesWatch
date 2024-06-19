package com.dominic.movieswatch.di

import com.dominic.movieswatch.repository.MovieRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    single { get<Retrofit>().create(MovieApiService::class.java) }
//
//    single { MovieRepository(get(), get()) }
//
//    viewModel { MovieViewModel(get()) }
//    viewModel { SearchViewModel(get()) }
//    viewModel { FavoriteViewModel(get()) }
//
//    // Room Database
//    single { AppDatabase.getDatabase(get()) }
//    single { get<AppDatabase>().movieDao() }
}