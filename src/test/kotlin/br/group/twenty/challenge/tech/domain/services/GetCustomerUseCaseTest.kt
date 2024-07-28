package br.group.twenty.challenge.tech.domain.services

class GetCustomerUseCaseTest {
//    private val customerJpaRepositoryMock = mockk<ICustomerDataSource>()
//    private val createAdapter = CustomerGateway(customerJpaRepositoryMock)
//    private val findRepository = FindCustomerAdapter(customerJpaRepositoryMock)
//
//    @Test
//    fun `Should find a customer`() {
//        every { customerJpaRepositoryMock.findByCpf("41596822864") } returns null
//        every { customerJpaRepositoryMock.save(any()) } returns CustomerEntity(
//            idCustomer = 1,
//            name = "regina",
//            email = "regina@gmail.com",
//            cpf = "41596822864"
//        )
//
//        createAdapter.createCustomer(CreateCustomer(name = "regina", email = "regina@gmail.com", cpf = "41596822864"))
//        every { customerJpaRepositoryMock.findByCpf("41596822864") } returns CustomerEntity(
//            idCustomer = 1,
//            name = "regina",
//            email = "regina@gmail.com",
//            cpf = "41596822864"
//        )
//        val output = findRepository.findCustomerByCpf("41596822864")
//
//        assertEquals(1, output?.idCustomer)
//        assertEquals("regina", output?.name)
//        assertEquals("regina@gmail.com", output?.email)
//        assertEquals("41596822864", output?.cpf)
//    }
//
//    @Test
//    fun `Should customer not found`() {
//        every { customerJpaRepositoryMock.findByCpf("42985789886") } returns null
//        val output = findRepository.findCustomerByCpf("42985789886")
//        assertEquals(null, output)
//    }
}