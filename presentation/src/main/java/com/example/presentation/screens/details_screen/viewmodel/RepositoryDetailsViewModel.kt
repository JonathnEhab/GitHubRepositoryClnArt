package com.example.presentation.screens.details_screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.usecase.FetchRepositoryDetailsUseCase
import com.example.presentation.mapper.toCustomExceptionPresentationModel
import com.example.presentation.mapper.toRepositoryDetailsUIModel
import com.example.presentation.screens.details_screen.ui_state.RepositoryDetailsUiState
import com.example.presentation.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryDetailsViewModel @Inject constructor(
    private val fetchRepositoryDetailsUseCase: FetchRepositoryDetailsUseCase,
    private val dispatcherProvider: DispatcherProvider
): ViewModel(){

    private val _repositoryDetailsState = MutableStateFlow<RepositoryDetailsUiState>(
        RepositoryDetailsUiState(isLoading = true))

    val repositoryUiState get() = _repositoryDetailsState.asStateFlow()

    fun requestRepositoryDetails(owner: String, name: String){
        _repositoryDetailsState.value= RepositoryDetailsUiState(isLoading = true)
        viewModelScope.launch (dispatcherProvider.io){
            try {
                fetchRepositoryDetailsUseCase(owner,name).let {
                    _repositoryDetailsState.value= RepositoryDetailsUiState(
                        isLoading = false,
                        repositoryDetails = it.toRepositoryDetailsUIModel()
                    )
                    Log.d("TAG", "Repo Details Response: $_repositoryDetailsState")

                }
            }catch (e : Exception){
                Log.d("TAG", "requestRepositoryDetails: ${e.message}")
                Log.d("TAG", "requestRepositoryDetails: ${e::class.simpleName} - ${e.localizedMessage} - $e")
                _repositoryDetailsState.value = RepositoryDetailsUiState(
                    isLoading = false,
                    isError = true,

                    customExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                )
            }
        }
    }
}