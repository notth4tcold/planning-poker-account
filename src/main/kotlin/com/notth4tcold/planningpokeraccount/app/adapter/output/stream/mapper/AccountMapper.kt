package com.notth4tcold.planningpokeraccount.app.adapter.output.stream.mapper

import com.notth4tcold.planningpokeraccount.app.adapter.output.stream.event.AccountCreatedEvent
import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountDomain.toEvent() = AccountCreatedEvent(id = id, accountId = accountId)