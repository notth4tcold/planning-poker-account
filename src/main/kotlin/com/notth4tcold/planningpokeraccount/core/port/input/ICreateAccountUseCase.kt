package com.notth4tcold.planningpokeraccount.core.port.input

import com.notth4tcold.planningpokeraccount.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

interface ICreateAccountUseCase {
    fun create(account: AccountRequest): AccountDomain
}