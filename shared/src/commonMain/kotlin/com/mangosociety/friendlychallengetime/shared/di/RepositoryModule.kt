package com.mangosociety.friendlychallengetime.shared.di

import com.mangosociety.friendlychallengetime.shared.data.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        AuthRepository(get())
    }
}