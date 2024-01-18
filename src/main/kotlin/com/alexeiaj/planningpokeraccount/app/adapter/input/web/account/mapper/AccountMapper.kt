package com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.mapper

import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountResponse
import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountDomain.toResponse() = AccountResponse(id = id, accountId = accountId)