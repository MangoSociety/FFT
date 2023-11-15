package com.mangosociety.friendlychallengetime.shared

import kotlinx.coroutines.CoroutineDispatcher

interface FFTCoroutineDispatcher {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val fftDispatchers: FFTCoroutineDispatcher