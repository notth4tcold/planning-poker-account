package com.alexeiaj.planningpokeraccount.app.adapter.input.stream

import com.alexeiaj.planningpokeraccount.app.adapter.input.stream.mapper.toAccountCreated
import com.alexeiaj.planningpokeraccount.app.adapter.output.stream.event.AccountCreatedEvent
import java.util.function.Consumer
import org.springframework.stereotype.Component

@Component("account-created-stream")
class AccountCreatedStreamConsumer : Consumer<AccountCreatedEvent> {

    override fun accept(event: AccountCreatedEvent) {
        println(event.toAccountCreated())
    }
}