package com.notth4tcold.kotlinapp.app.adapter.input.web.account.mapper

import com.notth4tcold.kotlinapp.app.adapter.input.web.account.dto.AccountResponse
import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

fun AccountDomain.toResponse() = AccountResponse(id = id, accountId = accountId)