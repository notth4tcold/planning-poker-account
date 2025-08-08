package com.notth4tcold.planningpokeraccount.app.adapter.input.stream.mapper

import com.notth4tcold.planningpokeraccount.app.adapter.input.stream.dto.AccountCreated
import com.notth4tcold.planningpokeraccount.app.adapter.input.web.account.dto.AccountResponse
import com.notth4tcold.planningpokeraccount.app.adapter.output.stream.event.AccountCreatedEvent
import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountCreatedEvent.toAccountCreated() = AccountCreated(id = id, accountId = accountId)