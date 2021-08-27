package com.araikovich.yandesx_sdk.data.mapper

interface Mapper<SOURCE, RESULT> {

    fun map(source: SOURCE): RESULT

    fun list(source: List<SOURCE>): List<RESULT> {
        val mappedItems = mutableListOf<RESULT>()
        source.forEach { item ->
            mappedItems.add(map(item))
        }
        return mappedItems
    }
}