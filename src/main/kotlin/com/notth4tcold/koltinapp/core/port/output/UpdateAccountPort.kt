package com.notth4tcold.kotlinapp.core.port.output

import com.notth4tcold.kotlinapp.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

interface UpdateAccountPort {
    fun update(id: String, account: AccountRequest): AccountDomain?
}