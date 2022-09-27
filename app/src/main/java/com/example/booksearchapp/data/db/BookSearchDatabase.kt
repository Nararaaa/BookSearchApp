package com.example.booksearchapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.booksearchapp.data.model.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(OrmConverter::class)
abstract class BookSearchDatabase : RoomDatabase() {

    abstract fun bookSearchDao(): BookSearchDao

// 앱모듈에서 싱글톤으로 만들기때문에 해당 클래스에서 수동생성할 필요없음
/*
    companion object {
        @Volatile
        private var INSTANCE: BookSearchDatabase? = null

        private fun buildDatabase(context: Context): BookSearchDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                BookSearchDatabase::class.java,
                "favorite-books"
            ).build()

        fun getInstance(context: Context): BookSearchDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
    }

 */
}
