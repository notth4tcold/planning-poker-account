package com.notth4tcold.kotlinapp.core.port.output.stream

import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

interface AccountCreatedProducerPort {

    fun send(account: AccountDomain): Boolean
}