package com.notth4tcold.kotlin-app.app.adapter.output.persistence.mapper

import com.notth4tcold.kotlin-app.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlin-app.app.adapter.output.persistence.entity.AccountEntity
import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain

fun AccountRequest.toEntity() = AccountEntity(accountId = accountId)

fun AccountEntity.toDTO() = AccountDomain(id = id!!, accountId = accountId!!)