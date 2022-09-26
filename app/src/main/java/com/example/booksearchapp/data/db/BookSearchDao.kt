package com.example.booksearchapp.data.db

import androidx.paging.PagingSource
import androidx.room.*
import com.example.booksearchapp.data.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookSearchDao {

    // Query를 제외한 CUD는 시간이 걸리기 때문에 코루틴 안에서 비동기로 수행할 예정으로 suspend로 함수 구현
    @Insert(onConflict = OnConflictStrategy.REPLACE) // 동일한 isbn을 가진 데이터가 존재할 경우 덮어씌우기
    suspend fun insertBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM books")
    fun getFavoriteBooks(): Flow<List<Book>>

    @Query("SELECT * FROM books")
    fun getFavoritePagingBooks(): PagingSource<Int, Book>
}