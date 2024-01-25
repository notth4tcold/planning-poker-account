package com.alexeiaj.planningpokeraccount.core.port.output

import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain

interface FindByIdAccountPort {
    fun findById(id: String): AccountDomain?
}