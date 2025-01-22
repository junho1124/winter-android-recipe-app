package com.surivalcoding.composerecipeapp.core.domain.useCase

import com.surivalcoding.composerecipeapp.core.model.Result

interface UseCase<in P : UseCaseParams, out R: Result<*, *>> {
    suspend operator fun invoke(params: P): R

}

typealias VoidParamUseCase<R> = UseCase<VoidParams, R>
