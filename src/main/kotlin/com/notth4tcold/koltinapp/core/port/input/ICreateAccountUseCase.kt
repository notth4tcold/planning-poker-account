package com.notth4tcold.kotlinapp.core.port.input

import com.notth4tcold.kotlinapp.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

interface ICreateAccountUseCase {
    fun create(account: AccountRequest): AccountDomain
}