package `in`.xparticle.dotnews.ui.fragments

import `in`.xparticle.dotnews.R
import `in`.xparticle.dotnews.ui.NewsActivity
import `in`.xparticle.dotnews.ui.NewsViewModel
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel : NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        val article = args.article
        view.findViewById<WebView>(R.id.webView).apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article saved successfully..",Snackbar.LENGTH_SHORT).show()
        }

    }

}