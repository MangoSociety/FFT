package com.mangosociety.friendlychallengetime.shared.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.mangosociety.friendlychallengetime.shared.commonMain.FFTDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

actual fun Scope.sqlDriverFactory(): SqlDriver {
    return AndroidSqliteDriver(FFTDatabase.Schema, androidContext(), "${DatabaseConstants.name}.db")
}