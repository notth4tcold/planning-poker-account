package com.alexeiaj.planningpokeraccount.core.port.input

import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

interface IFindAllAccountUseCase {
    fun findAll(): List<AccountDomain>
}