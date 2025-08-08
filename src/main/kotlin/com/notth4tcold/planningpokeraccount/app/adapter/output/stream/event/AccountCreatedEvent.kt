package com.notth4tcold.planningpokeraccount.app.adapter.output.stream.event

import com.notth4tcold.planningpokeraccount.core.common.annotation.NoArgsConstructor

@NoArgsConstructor
data class AccountCreatedEvent(val id: String, val accountId: String)