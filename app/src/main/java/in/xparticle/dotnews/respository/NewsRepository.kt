package `in`.xparticle.dotnews.respository

import `in`.xparticle.dotnews.api.RetrofitInstance
import `in`.xparticle.dotnews.db.ArticleDatabase
import `in`.xparticle.dotnews.models.Article
import android.app.DownloadManager
import retrofit2.Retrofit

class NewsRepository(
    val db:  ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String,pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)


    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)


}