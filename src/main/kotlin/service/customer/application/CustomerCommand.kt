package service.customer.application

sealed class CustomerCommand{
    class CreateCustomer(val id: String, val name: String, val cpf: String): CustomerCommand()
}