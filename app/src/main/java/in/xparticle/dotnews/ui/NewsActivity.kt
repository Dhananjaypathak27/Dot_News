package `in`.xparticle.dotnews.ui

import `in`.xparticle.dotnews.R
import `in`.xparticle.dotnews.db.ArticleDatabase
import `in`.xparticle.dotnews.respository.NewsRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))

        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)


        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(findViewById<View>(R.id.newsNavHostFragment).findNavController()   )
    }
}