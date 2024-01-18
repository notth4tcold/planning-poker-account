package com.alexeiaj.planningpokeraccount.app.adapter.input.web.account

import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountRequest
import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.dto.AccountResponse
import com.alexeiaj.planningpokeraccount.app.adapter.input.web.account.mapper.toResponse
import com.alexeiaj.planningpokeraccount.core.port.input.ICreateAccountUseCase
import com.alexeiaj.planningpokeraccount.core.port.input.IDeleteAccountUseCase
import com.alexeiaj.planningpokeraccount.core.port.input.IFindAllAccountUseCase
import com.alexeiaj.planningpokeraccount.core.port.input.IFindByIdAccountUseCase
import com.alexeiaj.planningpokeraccount.core.port.input.IUpdateAccountUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountResource (
        private val findByIdAccountUseCase : IFindByIdAccountUseCase,
        private val findAllAccountUseCase : IFindAllAccountUseCase,
        private val createAccountUseCase : ICreateAccountUseCase,
        private val updateAccountUseCase : IUpdateAccountUseCase,
        private val deleteAccountUseCase : IDeleteAccountUseCase,
) {

    @GetMapping
    fun findAll(): List<AccountResponse> =
            findAllAccountUseCase.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(
            @PathVariable
            id: Long,
    ): AccountResponse = findByIdAccountUseCase.findById(id).toResponse()

    @PostMapping
    fun create(
            @RequestBody
            account: AccountRequest,
    ): AccountResponse = createAccountUseCase.create(account).toResponse()

    @PutMapping("/{id}")
    fun update(
            @PathVariable
            id: Long,
            @RequestBody
            account: AccountRequest,
    ): AccountResponse = updateAccountUseCase.update(id, account).toResponse()

    @DeleteMapping("/{id}")
    fun delete(
            @PathVariable
            id: Long,
    ) = deleteAccountUseCase.delete(id)
}