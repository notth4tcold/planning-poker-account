package com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.mapper

import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountRequest
import com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.entity.AccountEntity
import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

fun AccountRequest.toEntity() = AccountEntity(accountId = accountId)

fun AccountEntity.toDTO() = AccountDomain(id = id!!, accountId = accountId!!)