package com.comeonyo

import com.comeonyo.domain.di.appModule
import com.comeonyo.infra.database.DbInitializer
import com.comeonyo.server.features.configureCallLogging
import com.comeonyo.server.features.configureContentNegotiation
import com.comeonyo.server.features.configureExceptionHandling
import com.comeonyo.server.routes.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }

    DbInitializer.init(environment.config)

    configureCallLogging()
    configureContentNegotiation()
    configureExceptionHandling()
    configureRouting()
}
