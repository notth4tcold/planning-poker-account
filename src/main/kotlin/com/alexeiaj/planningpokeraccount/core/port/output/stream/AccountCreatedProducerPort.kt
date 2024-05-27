package com.alexeiaj.planningpokeraccount.core.port.output.stream

import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

interface AccountCreatedProducerPort {

    fun send(account: AccountDomain): Boolean
}