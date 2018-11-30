package service.customer.infrastructure.persistence

import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.repository.MongoRepository
import service.customer.domain.model.customer.Customer
import service.customer.domain.model.customer.CustomerEvent

@Repository
interface CustomerEventRepository : MongoRepository<CustomerEvent, String>{
    fun save(customer: Customer): Customer
}