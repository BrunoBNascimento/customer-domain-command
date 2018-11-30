package service.customer.domain.model.customer

import service.customer.domain.model.DomainEvent

sealed class CustomerEvent : DomainEvent

data class CreatedCustomer(val data: Customer, val eventName: String = CreatedCustomer::class.simpleName.toString()) : CustomerEvent()

data class UpdateCustomer(val data: Customer, val eventName: String = CreatedCustomer::javaClass.name) : CustomerEvent()
