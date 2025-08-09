package com.notth4tcold.kotlin-app.app.adapter.output.stream.event

import com.notth4tcold.kotlin-app.core.common.annotation.NoArgsConstructor

@NoArgsConstructor
data class AccountCreatedEvent(val id: String, val accountId: String)