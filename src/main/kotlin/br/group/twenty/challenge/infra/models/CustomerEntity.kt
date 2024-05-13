package br.group.twenty.challenge.infra.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_customer")
data class CustomerEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val idCustomer: Int? = null,
    val name: String,
    val email: String,
    val cpf: String
) {
    init {
        validCustomerFields()
    }

    private fun validCustomerFields() {
        if (!isValidEmail(email)) throw Exception("Invalid email")
        if (!isValidCPF(cpf)) throw Exception("Invalid cpf")
        if (name.isBlank()) throw Exception("Name cannot be empty")
    }

    private fun isValidEmail(email: String): Boolean {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$")
        return regex.matches(email)
    }

    private fun isValidCPF(cpf: String): Boolean {
        val regex = Regex("^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})|(\\d{11})\$")
        return regex.matches(cpf)
    }

}
