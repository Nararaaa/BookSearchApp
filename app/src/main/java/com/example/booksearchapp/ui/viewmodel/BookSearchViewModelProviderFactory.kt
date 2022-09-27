package com.example.booksearchapp.ui.viewmodel

// 뷰모델을 델리게이트로 생성하기에 뷰모델 팩토리는 별도로 필요없어서 정리
//@Suppress("UNCHECKED_CAST")
/*class BookSearchViewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}*/
/*
class BookSearchViewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository,
    private val workManager: WorkManager,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository, workManager, handle) as T
        }
        throw IllegalArgumentException("viewModel class not found")
    }
}*/
