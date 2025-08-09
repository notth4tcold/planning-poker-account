package com.notth4tcold.kotlinapp.app.adapter.output.stream.mapper

import com.notth4tcold.kotlinapp.app.adapter.output.stream.event.AccountCreatedEvent
import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

fun AccountDomain.toEvent() = AccountCreatedEvent(id = id, accountId = accountId)