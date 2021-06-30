package `in`.xparticle.dotnews.models

import `in`.xparticle.dotnews.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int

)