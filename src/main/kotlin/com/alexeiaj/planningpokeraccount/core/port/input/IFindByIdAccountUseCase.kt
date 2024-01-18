package com.alexeiaj.planningpokeraccount.core.port.input

import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

interface IFindByIdAccountUseCase {
    fun findById(id: Long): AccountDomain
}