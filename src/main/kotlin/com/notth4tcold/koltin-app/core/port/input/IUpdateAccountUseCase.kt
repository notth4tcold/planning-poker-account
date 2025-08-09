package com.notth4tcold.kotlin-app.core.port.input

import com.notth4tcold.kotlin-app.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain

interface IUpdateAccountUseCase {
    fun update(id: String, account: AccountRequest): AccountDomain
}