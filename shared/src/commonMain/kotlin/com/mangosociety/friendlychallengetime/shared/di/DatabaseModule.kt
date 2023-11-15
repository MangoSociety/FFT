package com.mangosociety.friendlychallengetime.shared.di

import com.mangosociety.friendlychallengetime.shared.core.database.createDatabase
import com.mangosociety.friendlychallengetime.shared.core.database.dao.AuthDao
import com.mangosociety.friendlychallengetime.shared.core.database.sqlDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    factory { sqlDriverFactory() }
    single { createDatabase(driver = get()) }
    single { AuthDao(database = get()) }
}