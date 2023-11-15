package com.mangosociety.friendlychallengetime.shared.core.database

//import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlDriver
import com.mangosociety.friendlychallengetime.shared.commonMain.FFTDatabase
import org.koin.core.scope.Scope

expect fun Scope.sqlDriverFactory(): SqlDriver
fun createDatabase(driver: SqlDriver): FFTDatabase {
    val database = FFTDatabase(
        driver = driver,
    )

    return database
}