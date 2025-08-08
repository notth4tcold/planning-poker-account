package com.notth4tcold.planningpokeraccount.core.port.input

import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

interface IFindByIdAccountUseCase {
    fun findById(id: String): AccountDomain
}