package com.alexeiaj.planningpokeraccount.app.adapter.input.stream.mapper

import com.alexeiaj.planningpokeraccount.app.adapter.input.stream.dto.AccountCreated
import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountResponse
import com.alexeiaj.planningpokeraccount.app.adapter.output.stream.event.AccountCreatedEvent
import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountCreatedEvent.toAccountCreated() = AccountCreated(id = id, accountId = accountId)