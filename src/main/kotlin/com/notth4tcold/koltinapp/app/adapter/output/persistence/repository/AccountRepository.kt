package com.notth4tcold.kotlinapp.app.adapter.output.persistence.repository

import com.notth4tcold.kotlinapp.app.adapter.output.persistence.entity.AccountEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountRepository : MongoRepository<AccountEntity, String>