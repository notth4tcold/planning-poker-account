package com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.entity

import com.alexeiaj.planningpokeraccount.core.common.annotation.NoArgsConstructor
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "account")
@NoArgsConstructor
data class AccountEntity(
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        val id: Long? = null,

        @Column(name = "accountId", nullable = true, updatable = true)
        var accountId: String? = null,
)