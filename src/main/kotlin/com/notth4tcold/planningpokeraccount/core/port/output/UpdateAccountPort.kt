package com.notth4tcold.planningpokeraccount.core.port.output

import com.notth4tcold.planningpokeraccount.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

interface UpdateAccountPort {
    fun update(id: String, account: AccountRequest): AccountDomain?
}