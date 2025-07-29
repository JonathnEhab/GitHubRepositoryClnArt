package com.example.domain.repository

import com.example.domain.model.IssuesDomainModel
import java.security.acl.Owner

interface IssuesRepository {
    suspend fun fetchIssues(owner: String, name: String) : List<IssuesDomainModel>
}