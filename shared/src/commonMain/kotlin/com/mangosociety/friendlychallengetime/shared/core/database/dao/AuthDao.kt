package com.mangosociety.friendlychallengetime.shared.core.database.dao

import com.mangosociety.friendlychallengetime.shared.commonMain.FFTDatabase
import com.mangosociety.friendlychallengetime.shared.commonMain.UserVerifiedEntity
import com.mangosociety.friendlychallengetime.shared.fftDispatchers
import kotlinx.coroutines.withContext

class AuthDao(
    private val database: FFTDatabase
) {
    private val query get() = database.userVerifiedEntityQueries

    suspend fun insert(userVerified: UserVerifiedEntity) = withContext(fftDispatchers.io) {
        query.insert(userVerified)
    }

    suspend fun getAll() = withContext(fftDispatchers.io) {
        return@withContext query.select().executeAsList()
    }
//
//    suspend fun selectAllByPage(page: Long) = withContext(pokedexDispatchers.io) {
//        query.selectAllByPage(page = page).executeAsList()
//    }
//
//    suspend fun insert(pokemonEntity: PokemonEntity) = withContext(pokedexDispatchers.io) {
//        query.insert(pokemonEntity)
//    }
}