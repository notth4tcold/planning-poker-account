package com.notth4tcold.planningpokeraccount.app.adapter.input.web.account.mapper

import com.notth4tcold.planningpokeraccount.app.adapter.input.web.account.dto.AccountResponse
import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountDomain.toResponse() = AccountResponse(id = id, accountId = accountId)