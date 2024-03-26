package com.comeonyo.domain.domain.product

class ProductService(
    private val productRepository: ProductRepositoryImpl,
) {
    fun registerProduct(
        name: String,
        price: Int,
    ): Product {
        // validate
        require(!productRepository.existsProductByName(name)) {
            "Product already exists. name: $name"
        }

        return productRepository.createProduct(name, price)
    }

    fun getProducts(): List<Product> {
        return productRepository.getProducts()
    }

    fun getProductById(id: Int): Product {
        return productRepository.getProductById(id) ?: throw NoSuchElementException("Product not found. id: $id")
    }

    fun checkProductValid(id: Int): Boolean {
        return productRepository.existsProductById(id)
    }
}
