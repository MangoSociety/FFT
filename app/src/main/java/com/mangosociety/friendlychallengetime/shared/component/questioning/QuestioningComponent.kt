package com.mangosociety.friendlychallengetime.shared.component.questioning

interface QuestioningComponent {

    val variants: List<Category>

    data class Item(
        val id: Int,
        val titleId: Int,
        val iconId: Int
    )

    data class Category(
        val id: Int,
        val titleId: Int,
        val data: List<Item>
    )

}