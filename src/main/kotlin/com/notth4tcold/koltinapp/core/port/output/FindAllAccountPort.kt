package com.notth4tcold.kotlinapp.core.port.output

import com.notth4tcold.kotlinapp.core.domain.dto.AccountDomain

interface FindAllAccountPort {
    fun findAll(): List<AccountDomain>
}