package com.loc.newsapp.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.util.Constants.API_KEY

class NewsPagignSource(
    private val newsApi: NewsApi,
    private val sources: String

):PagingSource<Int,Article>() {

    private var totalNewsCount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try{
            val newsResponse = newsApi.getNews(sources = sources, page = page )
            totalNewsCount = newsResponse.articles.size
            Log.d("totalresults","${newsResponse.totalResults}")
            Log.d("totalnewscount","$totalNewsCount")

            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }
        catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e

            )

        }
    }


}