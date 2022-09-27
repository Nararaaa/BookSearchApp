package com.example.booksearchapp.di

import com.example.booksearchapp.data.repository.BookSearchRepository
import com.example.booksearchapp.data.repository.BookSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// 인터페이스인 Repository를 주입하기 위한 레포지토리 모듈
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Singleton
    @Binds
    abstract fun bindBookSearchRepository(
        bookSearchRepositoryImpl: BookSearchRepositoryImpl,
    ): BookSearchRepository

}