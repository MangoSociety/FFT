package com.mangosociety.friendlychallengetime.shared.utils

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
sealed class GameType : Parcelable {
    @Parcelize
    sealed class Romantic : GameType() {
        @Parcelize
        data object Fast : Romantic()
        @Parcelize
        data object Default : Romantic()
        @Parcelize
        data object WithText : Romantic()

    }

    @Parcelize
    sealed class Friends : GameType() {
        @Parcelize
        data object Fast : Friends()
        @Parcelize
        data object Default : Friends()
        @Parcelize
        data object WithText : Friends()

    }
}