package com.example.booksearchapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.booksearchapp.R
import com.example.booksearchapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //lateinit var bookSearchViewModel: BookSearchViewModel
    private lateinit var navController: NavController

    // 앱바에 있는 타이틀 수정
    private lateinit var appBarConfiguration: AppBarConfiguration

    // datastore 의존성 전달(싱글톤패턴)
/*
    private val Context.dataStore by preferencesDataStore(DATASTORE_NAME)
    private val workManager = WorkManager.getInstance(application)
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /* setupBottomNavigationView()
         if (savedInstanceState == null) {
             binding.bottomNavigationView.selectedItemId = R.id.fragment_search
         }
        */
        // jetpackNavigation 사용으로 기존에 객체받아온 것은 주석처리
        setupJetpackNavigation()

        /*       val database = BookSearchDatabase.getInstance(this)
               val bookSearchRepository = BookSearchRepositoryImpl(database, dataStore)
               val factory = BookSearchViewModelProviderFactory(bookSearchRepository, workManager, this)
               bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]
       */
    }

    private fun setupJetpackNavigation() {
        val host = supportFragmentManager
            .findFragmentById(R.id.booksearch_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            // 뒤로가기없이 모든 앱바를 탑레벨로 설정
            setOf(
                R.id.fragment_search, R.id.fragment_favorite, R.id.fragment_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    /*private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { it ->
        when (it.itemId) {
            R.id.fragment_search -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, SearchFragment())
                    .commit()
                true
            }
            R.id.fragment_favorite -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, FavoriteFragment())
                    .commit()
                true
            }
            R.id.fragment_settings -> {

                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SettingsFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }*/
}