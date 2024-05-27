package com.alexeiaj.planningpokeraccount.app.adapter.output.stream.event

import com.alexeiaj.planningpokeraccount.core.common.annotation.NoArgsConstructor

@NoArgsConstructor
data class AccountCreatedEvent(val id: String, val accountId: String)