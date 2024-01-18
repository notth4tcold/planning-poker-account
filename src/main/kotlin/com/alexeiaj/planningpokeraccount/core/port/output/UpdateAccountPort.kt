package com.alexeiaj.planningpokeraccount.core.port.output

import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountRequest
import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

interface UpdateAccountPort {
    fun update(id: Long, account: AccountRequest): AccountDomain?
}