package com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.repository

import com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, Long>