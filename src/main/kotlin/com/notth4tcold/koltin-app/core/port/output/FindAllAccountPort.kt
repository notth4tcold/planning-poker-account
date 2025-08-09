package com.notth4tcold.kotlin-app.core.port.output

import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain

interface FindAllAccountPort {
    fun findAll(): List<AccountDomain>
}