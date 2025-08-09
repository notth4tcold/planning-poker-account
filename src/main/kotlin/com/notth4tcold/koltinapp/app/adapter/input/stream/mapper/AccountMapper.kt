package com.notth4tcold.kotlinapp.app.adapter.input.stream.mapper

import com.notth4tcold.kotlinapp.app.adapter.input.stream.dto.AccountCreated
import com.notth4tcold.kotlinapp.app.adapter.input.web.account.dto.AccountResponse
import com.notth4tcold.kotlinapp.app.adapter.output.stream.event.AccountCreatedEvent
import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

fun AccountCreatedEvent.toAccountCreated() = AccountCreated(id = id, accountId = accountId)