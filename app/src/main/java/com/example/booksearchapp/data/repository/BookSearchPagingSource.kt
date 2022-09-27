package com.example.booksearchapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.booksearchapp.data.api.RetrofitInstance.api
import com.example.booksearchapp.data.model.Book
import com.example.booksearchapp.util.Constants.PAGING_SIZE
import okio.IOException
import retrofit2.HttpException

class BookSearchPagingSource(
    private val query: String,
    private val sort: String
) : PagingSource<Int, Book>() {
    override fun getRefreshKey(state: PagingState<Int, Book>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    // Pager가 데이터를 호출할때마다 불리는 함수
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX
            val response = api.searchBooks(query, sort, pageNumber, params.loadSize)
            val endOfPaginationReached = response.body()?.meta?.isEnd!!

            val data = response.body()?.documents!!
            val prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1
            val nextKey = if (endOfPaginationReached) {
                null
            } else {
                pageNumber + (params.loadSize / PAGING_SIZE)
            }
            LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
    }
}