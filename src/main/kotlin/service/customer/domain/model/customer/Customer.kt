package service.customer.domain.model.customer

import org.springframework.data.annotation.Id

data class Customer(@Id private val id: String, val name: String, val cpf: String)