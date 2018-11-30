package service.customer.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import service.customer.domain.model.customer.Customer
import service.customer.application.CustomerService
import service.customer.application.CustomerCommand.CreateCustomer
import java.util.*


@RestController
class CustomerResource(
        val customerService: CustomerService
) {
    @PostMapping
    fun createCustomer(@RequestBody customer : Customer): ResponseEntity<Customer> {
        val createdCustomer = customerService
                .createCustomer(
                        CreateCustomer(Date().time.toString(), customer.name, customer. cpf)
                )

        return ResponseEntity(createdCustomer, HttpStatus.CREATED)
    }
}
