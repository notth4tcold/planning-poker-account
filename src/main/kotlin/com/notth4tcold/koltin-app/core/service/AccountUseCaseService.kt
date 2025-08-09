package com.notth4tcold.kotlin-app.core.service

import com.notth4tcold.kotlin-app.app.adapter.input.web.account.dto.AccountRequest
import com.notth4tcold.kotlin-app.core.common.exception.AccountNotFoundException
import com.notth4tcold.kotlin-app.core.domain.dto.AccountDomain
import com.notth4tcold.kotlin-app.core.port.input.ICreateAccountUseCase
import com.notth4tcold.kotlin-app.core.port.input.IDeleteAccountUseCase
import com.notth4tcold.kotlin-app.core.port.input.IFindAllAccountUseCase
import com.notth4tcold.kotlin-app.core.port.input.IFindByIdAccountUseCase
import com.notth4tcold.kotlin-app.core.port.input.IUpdateAccountUseCase
import com.notth4tcold.kotlin-app.core.port.output.CreateAccountPort
import com.notth4tcold.kotlin-app.core.port.output.DeleteAccountPort
import com.notth4tcold.kotlin-app.core.port.output.FindAllAccountPort
import com.notth4tcold.kotlin-app.core.port.output.FindByIdAccountPort
import com.notth4tcold.kotlin-app.core.port.output.UpdateAccountPort
import com.notth4tcold.kotlin-app.core.port.output.stream.AccountCreatedProducerPort
import org.springframework.stereotype.Service

@Service
class AccountUseCaseService(
        private val createAccountPort: CreateAccountPort,
        private val updateAccountPort: UpdateAccountPort,
        private val findByIdAccountPort: FindByIdAccountPort,
        private val findAllAccountPort: FindAllAccountPort,
        private val deleteAccountPort: DeleteAccountPort,
        private val accountCreatedProducerPort: AccountCreatedProducerPort,
) : ICreateAccountUseCase, IUpdateAccountUseCase, IFindByIdAccountUseCase, IFindAllAccountUseCase, IDeleteAccountUseCase {

    override fun findAll(): List<AccountDomain> = findAllAccountPort.findAll()

    override fun findById(id: String): AccountDomain = findByIdAccountPort.findById(id)
            ?: throw AccountNotFoundException("ACCOUNT NOT FOUND")

    override fun create(account: AccountRequest): AccountDomain = createAccountPort.create(account)
            .apply { accountCreatedProducerPort.send(this) }

    override fun update(id: String, account: AccountRequest): AccountDomain = updateAccountPort.update(id, account)
            ?: throw AccountNotFoundException("ACCOUNT NOT FOUND")

    override fun delete(id: String) = deleteAccountPort.delete(id)
}