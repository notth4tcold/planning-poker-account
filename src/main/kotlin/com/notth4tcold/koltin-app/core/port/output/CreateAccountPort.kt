package com.notth4tcold.kotlin-app.core.port.output

import com.notth4tcold.kotlin-app.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain

interface CreateAccountPort {
    fun create(account: AccountRequest): AccountDomain
}