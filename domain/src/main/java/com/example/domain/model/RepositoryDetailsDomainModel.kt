package com.example.domain.model

data class RepositoryDetailsDomainModel (
    val id : Int,
    val name : String,
    val avatar : String,
    val descriptor: String,
    val fork : Int,
    val language: String,
    val fullName : String,
    val stars : Int,
    val url : String,
    val owner : String,
    val createdAt : String
)