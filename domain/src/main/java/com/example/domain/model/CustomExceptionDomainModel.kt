package com.example.domain.model

sealed class CustomExceptionDomainModel : Exception()  {

    object NoInternetConnectionExceptionDomainModel : CustomExceptionDomainModel()

    object TimeOutExceptionDomainModel : CustomExceptionDomainModel()

    object NetworkExceptionDomainModel : CustomExceptionDomainModel()

    object ServiceNotFoundExceptionDomainModel : CustomExceptionDomainModel()

    object AccessDeniedExceptionDomainModel : CustomExceptionDomainModel()

    object ServiceUnavailableExceptionDomainModel : CustomExceptionDomainModel()

    object UnknownExceptionDomainModel : CustomExceptionDomainModel()

}