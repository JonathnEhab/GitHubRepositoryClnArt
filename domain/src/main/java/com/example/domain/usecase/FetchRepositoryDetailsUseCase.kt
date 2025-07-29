package com.example.domain.usecase

import androidx.lifecycle.LifecycleOwner
import com.example.domain.model.RepositoryDetailsDomainModel
import com.example.domain.repository.RepoDetailsRepository

class FetchRepositoryDetailsUseCase
    (private val repoDetailsRepository: RepoDetailsRepository) {
    suspend operator fun invoke(owner: String, name: String): RepositoryDetailsDomainModel =
        repoDetailsRepository.fetchRepositoryDetails(owner, name)
}