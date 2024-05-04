package br.group.twenty.challenge.tech.domain

import br.group.twenty.challenge.domain.model.Customer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomerEntityTest {

    @Test
    fun `Throw an error if the email is in an invalid format`(){
        val exception = assertThrows<Exception> {
            Customer(name = "luqueta", cpf = "42987589824", email = "bigodes")
        }

        assertEquals("Invalid email", exception.message)
    }

    @Test
    fun `Throw an error if the cpf is in an invalid format`() {
        val exception = assertThrows<Exception> {
            Customer(name = "luqueta", cpf = "429875898256", email = "bigodes@gmail.com")
        }
        assertEquals("Invalid cpf", exception.message)
    }

    @Test
    fun `Throw an error if the name is blank`() {
        val exception = assertThrows<Exception> {
            Customer(name = " ", cpf = "42987589825", email = "bigodes@gmail.com")
        }
        assertEquals("Name cannot be empty", exception.message)
    }

    @Test
    fun `Should create a Customer with the provided data`() {
        val name = "bigodes"
        val cpf = "42987589824"
        val email = "bigodes@gmail.com"

        val customer = Customer(name = name, cpf = cpf, email = email)

        assertEquals(name, customer.name)
        assertEquals(cpf, customer.cpf)
        assertEquals(email, customer.email)
    }
}