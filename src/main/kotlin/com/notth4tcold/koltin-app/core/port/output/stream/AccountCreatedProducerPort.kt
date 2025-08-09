package com.notth4tcold.kotlin-app.core.port.output.stream

import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain

interface AccountCreatedProducerPort {

    fun send(account: AccountDomain): Boolean
}