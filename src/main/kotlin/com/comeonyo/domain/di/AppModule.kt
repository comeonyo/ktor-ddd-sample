package com.comeonyo.domain.di

import com.comeonyo.domain.application.order.OrderApplicationService
import com.comeonyo.domain.application.product.ProductApplicationService
import com.comeonyo.domain.application.user.UserApplicationService
import com.comeonyo.domain.domain.order.OrderRepository
import com.comeonyo.domain.domain.order.OrderRepositoryImpl
import com.comeonyo.domain.domain.order.OrderService
import com.comeonyo.domain.domain.product.ProductRepository
import com.comeonyo.domain.domain.product.ProductRepositoryImpl
import com.comeonyo.domain.domain.product.ProductService
import com.comeonyo.domain.domain.user.UserRepository
import com.comeonyo.domain.domain.user.UserRepositoryImpl
import com.comeonyo.domain.domain.user.UserService
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule =
    module {
        singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
        singleOf(::UserService) { bind<UserService>() }

        singleOf(::ProductRepositoryImpl) { bind<ProductRepository>() }
        singleOf(::ProductService) { bind<ProductService>() }

        singleOf(::OrderRepositoryImpl) { bind<OrderRepository>() }
        singleOf(::OrderService) { bind<OrderService>() }

        singleOf(::OrderApplicationService) { bind<OrderApplicationService>() }
        singleOf(::ProductApplicationService) { bind<ProductApplicationService>() }
        singleOf(::UserApplicationService) { bind<UserApplicationService>() }
    }
