package com.notth4tcold.kotlinapp.core.port.input

import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

interface IFindByIdAccountUseCase {
    fun findById(id: String): AccountDomain
}