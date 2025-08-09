package com.notth4tcold.kotlin-app.app.adapter.output.persistence

import com.notth4tcold.kotlin-app.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlin-app.app.adapter.output.persistence.mapper.toDTO
import com.notth4tcold.kotlin-app.app.adapter.output.persistence.mapper.toEntity
import com.notth4tcold.kotlin-app.app.adapter.output.persistence.repository.AccountRepository
import com.notth4tcold.kotlin-app.core.common.exception.AccountNotFoundException
import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain
import com.notth4tcold.kotlin-app.core.port.output.CreateAccountPort
import com.notth4tcold.kotlin-app.core.port.output.DeleteAccountPort
import com.notth4tcold.kotlin-app.core.port.output.FindAllAccountPort
import com.notth4tcold.kotlin-app.core.port.output.FindByIdAccountPort
import com.notth4tcold.kotlin-app.core.port.output.UpdateAccountPort
import org.springframework.stereotype.Component

@Component
class AccountAdapter(
        private val accountRepository: AccountRepository,
) : CreateAccountPort, UpdateAccountPort, FindByIdAccountPort, FindAllAccountPort, DeleteAccountPort {

    override fun findAll(): List<AccountDomain> =
            accountRepository.findAll().map { it.toDTO() }

    override fun findById(id: String): AccountDomain? =
            accountRepository.findById(id).takeIf { it.isPresent }?.get()?.toDTO()

    override fun create(account: AccountRequest): AccountDomain =
            account.toEntity()
                    .run { accountRepository.save(this) }
                    .toDTO()

    override fun update(id: String, account: AccountRequest): AccountDomain? =
            accountRepository.findById(id).takeIf { it.isPresent }?.get()
                    ?.apply { this.accountId = account.accountId }
                    ?.also { accountRepository.save(it) }
                    ?.toDTO()

    override fun delete(id: String) {
        accountRepository.findById(id).takeIf { it.isPresent }?.get()
                ?.also { accountRepository.delete(it) }
                ?: throw AccountNotFoundException("ACCOUNT NOT FOUND")
    }

}