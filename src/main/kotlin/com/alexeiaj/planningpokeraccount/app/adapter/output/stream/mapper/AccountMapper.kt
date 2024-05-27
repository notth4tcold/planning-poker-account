package com.alexeiaj.planningpokeraccount.app.adapter.output.stream.mapper

import com.alexeiaj.planningpokeraccount.app.adapter.output.stream.event.AccountCreatedEvent
import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountDomain.toEvent() = AccountCreatedEvent(id = id, accountId = accountId)