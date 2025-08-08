package com.notth4tcold.planningpokeraccount.app.adapter.output.stream

import com.notth4tcold.planningpokeraccount.app.adapter.output.stream.mapper.toEvent
import com.notth4tcold.planningpokeraccount.core.domain.dto.AccountDomain
import com.notth4tcold.planningpokeraccount.core.port.output.stream.AccountCreatedProducerPort
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class AccountCreatedStreamProducer(
        private val streamBridge: StreamBridge
): AccountCreatedProducerPort {

    override fun send(account: AccountDomain): Boolean =
            streamBridge.send(
                    "account-created-stream-out-0",
                    MessageBuilder.withPayload(account.toEvent())
                            .setHeader(KafkaHeaders.KEY, account.id)
                            .build()
            )
}