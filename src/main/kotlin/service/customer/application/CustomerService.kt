package service.customer.application

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.stereotype.Service
import service.customer.application.CustomerCommand.CreateCustomer
import service.customer.domain.model.customer.CreatedCustomer
import service.customer.domain.model.customer.Customer
import service.customer.infrastructure.persistence.CustomerEventRepository
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder

@Service
class CustomerService(
        val customerEventRepository: CustomerEventRepository
) {
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    private val logger = LoggerFactory.getLogger(CustomerService::class.java)

    fun createCustomer(c: CreateCustomer): Customer{
        val customer = Customer(c.id, c.name, c.cpf)
        val event = CreatedCustomer(customer)
        val eventSaved = customerEventRepository.save(event)
        val message: Message<CreatedCustomer> = MessageBuilder
                .withPayload(eventSaved)
                .setHeader(KafkaHeaders.TOPIC, "CustomerEvents")
                .build()

        kafkaTemplate?.send(message)
        logger.info(event.toString())

        return customer
    }
}