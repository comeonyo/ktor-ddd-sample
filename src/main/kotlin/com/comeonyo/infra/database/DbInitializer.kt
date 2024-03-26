package com.comeonyo.infra.database

import com.comeonyo.domain.domain.order.OrderTable
import com.comeonyo.domain.domain.product.ProductTable
import com.comeonyo.domain.domain.user.UserTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.ApplicationConfig
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DbInitializer {
    fun init(config: ApplicationConfig) {
        val driverClassName = config.property("storage.driverClassName").getString()
        val jdbcURL = config.property("storage.jdbcURL").getString()
        Database.connect(createHikariDataSource(url = jdbcURL, driver = driverClassName))

        transaction {
            // SchemaUtils를 사용하여 데이터베이스 테이블 생성
            SchemaUtils.create(UserTable, OrderTable, ProductTable)

            // 필요한 경우, 여기에 초기 데이터 삽입 로직을 추가할 수 있음
            // 예:
            // UserTables.insert { it[name] = "John Doe"; it[email] = "john@example.com" }
        }
    }

    private fun createHikariDataSource(
        url: String,
        driver: String,
    ) = HikariDataSource(
        HikariConfig().apply {
            driverClassName = driver
            jdbcUrl = url
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        },
    )
}
