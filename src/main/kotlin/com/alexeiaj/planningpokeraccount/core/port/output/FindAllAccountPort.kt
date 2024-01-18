package com.alexeiaj.planningpokeraccount.core.port.output

import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

interface FindAllAccountPort {
    fun findAll(): List<AccountDomain>
}