package com.example.retrofit.model

data class WikiResponse(
    val query: QueryResult
)

data class QueryResult(
    val searchinfo: SearchInfo
)

data class SearchInfo(
    val totalhits: Int
)

