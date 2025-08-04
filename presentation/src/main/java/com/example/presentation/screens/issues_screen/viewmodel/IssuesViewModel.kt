package com.example.presentation.screens.issues_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.model.IssueState
import com.example.domain.usecase.FetchIssuesUseCase
import com.example.presentation.mapper.toCustomExceptionPresentationModel
import com.example.presentation.mapper.toIssuesUiModel
import com.example.presentation.screens.issues_screen.ui_state.IssuesUiState
import com.example.presentation.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssuesViewModel @Inject constructor(
    private val fetchIssuesUseCase: FetchIssuesUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel(){
    private val _issuesState = MutableStateFlow<IssuesUiState>(IssuesUiState(isLoading = true))

    val issuesUiState get() = _issuesState.asStateFlow()

    fun requestIssues(owner : String, name : String){
        _issuesState.value = IssuesUiState(isLoading = true)
        viewModelScope.launch(dispatcherProvider.io) {
            try {
                fetchIssuesUseCase(owner,name).let { issuesList ->
                    _issuesState.value = IssuesUiState(
                        isError = false,
                        issuesList = issuesList.map { it.toIssuesUiModel() }
                    )
                }
            }catch (e : Exception){
                _issuesState.value = IssuesUiState(
                    isLoading = false,
                    isError = true,
                    customerErrorExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                )
            }
        }
    }
}