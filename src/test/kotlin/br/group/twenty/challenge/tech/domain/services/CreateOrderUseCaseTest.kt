package br.group.twenty.challenge.tech.domain.services

class CreateOrderUseCaseTest {
//    private val orderRepositoryMock = mockk<IOrderDataSource>()
//    private val findProductAdapter = mockk<FindProductAdapter>()
//    private val createOrderAdapter = CreateOrderAdapter(orderRepositoryMock, findProductAdapter)
//
//    @Test
//    fun `Should throw an error if the order already exists`() {
//        val input = CreateOrderModel(idCustomer = 1, productList = mutableListOf())
//        every { orderRepositoryMock.save(any()) } throws Exception("Order already exists")
//
//        val exception = assertThrows<Exception> {
//            createOrderAdapter.createOrder(input)
//        }
//        assertEquals("Order already exists", exception.message)
//    }
//
//    @Test
//    fun `Should register an order`() {
//        val input = CreateOrderModel(idCustomer = 1, productList = mutableListOf())
//        val orderEntity = OrderEntity(
//            idOrder = 1,
//            orderValue = BigDecimal("100.00"),
//            idCustomer = 1,
//            creationOrder = LocalDateTime.now(),
//            lastUpdateOrder = LocalDateTime.now(),
//            status = "PENDING",
//            mutableListOf()
//        )
//        val expectedOutput = OrderEntity(
//            idOrder = 1,
//            orderValue = BigDecimal("100.00"),
//            idCustomer = 1,
//            creationOrder = orderEntity.creationOrder,
//            lastUpdateOrder = orderEntity.lastUpdateOrder,
//            status = "PENDING",
//            mutableListOf()
//        )
//
//        every { orderRepositoryMock.save(any()) } returns orderEntity
//
//        val output = createOrderAdapter.createOrder(input)
//        assertEquals(expectedOutput, output)
//    }
}
