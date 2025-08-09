package com.notth4tcold.kotlin-app.core.port.input

import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain

interface IFindByIdAccountUseCase {
    fun findById(id: String): AccountDomain
}