package com.example.retrofit.repository

import com.example.retrofit.model.WikiResponse
import com.example.retrofit.network.WikiApi

class WikiRepository {
    private val wikiApi = WikiApi.create()

    suspend fun hitCountCheck(name: String): WikiResponse {
        return wikiApi.getHitsForName(name)
    }
}
