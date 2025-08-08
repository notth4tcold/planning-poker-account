package com.notth4tcold.planningpokeraccount.core.port.output.stream

import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

interface AccountCreatedProducerPort {

    fun send(account: AccountDomain): Boolean
}