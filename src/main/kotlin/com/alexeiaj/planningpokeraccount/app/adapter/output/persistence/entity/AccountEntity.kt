package com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.entity

import com.alexeiaj.planningpokeraccount.core.common.annotation.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("account")
@NoArgsConstructor
data class AccountEntity(
        @Id
        val id: String? = null,
        var accountId: String? = null,
)