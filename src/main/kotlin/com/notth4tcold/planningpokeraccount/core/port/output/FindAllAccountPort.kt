package com.notth4tcold.planningpokeraccount.core.port.output

import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain

interface FindAllAccountPort {
    fun findAll(): List<AccountDomain>
}