package com.alexeiaj.planningpokeraccount.app.adapter.output.persistence

import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountRequest
import com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.mapper.toDTO
import com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.mapper.toEntity
import com.alexeiaj.planningpokeraccount.app.adapter.output.persistence.repository.AccountRepository
import com.alexeiaj.planningpokeraccount.core.common.exception.AccountNotFoundException
import com.alexeiaj.planningpokeraccount.core.domain.dto.AccountDomain
import com.alexeiaj.planningpokeraccount.core.port.output.CreateAccountPort
import com.alexeiaj.planningpokeraccount.core.port.output.DeleteAccountPort
import com.alexeiaj.planningpokeraccount.core.port.output.FindAllAccountPort
import com.alexeiaj.planningpokeraccount.core.port.output.FindByIdAccountPort
import com.alexeiaj.planningpokeraccount.core.port.output.UpdateAccountPort
import org.springframework.stereotype.Component

@Component
class AccountAdapter(
        private val accountRepository: AccountRepository,
) : CreateAccountPort, UpdateAccountPort, FindByIdAccountPort, FindAllAccountPort, DeleteAccountPort {

    override fun findAll(): List<AccountDomain> =
            accountRepository.findAll().map { it.toDTO() }

    override fun findById(id: Long): AccountDomain? =
            accountRepository.findById(id).takeIf { it.isPresent }?.get()?.toDTO()

    override fun create(account: AccountRequest): AccountDomain =
            account.toEntity()
                    .run { accountRepository.save(this) }
                    .toDTO()

    override fun update(id: Long, account: AccountRequest): AccountDomain? =
            accountRepository.findById(id).takeIf { it.isPresent }?.get()
                    ?.apply { this.accountId = account.accountId }
                    ?.also { accountRepository.save(it) }
                    ?.toDTO()

    override fun delete(id: Long) {
        accountRepository.findById(id).takeIf { it.isPresent }?.get()
                ?.also { accountRepository.delete(it) }
                ?: throw AccountNotFoundException("ACCOUNT NOT FOUND")
    }

}