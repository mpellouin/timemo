package com.mpellouin.timemo.wire.database.infrastructure.secondary;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.mpellouin.timemo" }, enableDefaultTransactions = false)
class DatabaseConfiguration {}
