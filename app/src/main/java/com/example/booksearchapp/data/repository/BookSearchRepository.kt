package com.example.booksearchapp.data.repository

import androidx.paging.PagingData
import com.example.booksearchapp.data.model.Book
import com.example.booksearchapp.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface BookSearchRepository {

    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<SearchResponse>

    // Room DAO를 조작하기위한 메소드
    suspend fun insertBooks(book: Book)

    suspend fun deleteBooks(book: Book)

    fun getFavoriteBooks(): Flow<List<Book>>

    // DataStore 
    // 값을 저장하고 불러오는 메소드
    suspend fun saveSortMode(mode: String)

    suspend fun getSortMode(): Flow<String>

    // 버튼 설정을 저장하는 메소드
    suspend fun saveCacheDeleteMode(mode: Boolean)

    suspend fun getCacheDeleteMode(): Flow<Boolean>

    // Paging
    fun getFavoritePagingBooks(): Flow<PagingData<Book>>

    // pager가 pagingSource 결과를 pagingData로 변환하기위한 메소드
    fun searchBooksPaging(query: String, sort: String): Flow<PagingData<Book>>
}