package com.notth4tcold.kotlinapp.core.port.input

import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

interface IFindAllAccountUseCase {
    fun findAll(): List<AccountDomain>
}