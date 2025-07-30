package com.example.data.mapper

import com.example.data.data_source.local.entities.TrendingRepositoriesEntity
import com.example.data.data_source.remote.dto.trending_repo.Item

fun Item.toTrendingRepositoriesEntity(): TrendingRepositoriesEntity {
    return TrendingRepositoriesEntity(
        id = id,
        name = name,
        avatar = owner.avatarUrl,
        description = description,
        forks = forks,
        language = language ?: "",
        fullName = fullName,
        stars = stargazersCount,
        url = url,
        owner = owner.login
    )
}
