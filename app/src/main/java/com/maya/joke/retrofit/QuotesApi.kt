package com.maya.joke.retrofit

import retrofit2.Response
import retrofit2.http.GET
interface QuotesApi {
    @GET("{api?}")
    suspend fun getQuotes() : Response<QuoteList>
}