package com.mangosociety.friendlychallengetime.shared.component.questioning

import com.arkivanov.decompose.ComponentContext
import com.mangosociety.friendlychallengetime.R

class DefaultQuestioningComponent(
    componentContext: ComponentContext
) : QuestioningComponent, ComponentContext by componentContext {

    override val variants: List<QuestioningComponent.Category> = listOf(
        QuestioningComponent.Category(
            id = 1,
            titleId = R.string.questioning_type_music,
            data = listOf(
                QuestioningComponent.Item(
                    id = 11,
                    titleId = R.string.questioning_classic,
                    iconId = R.drawable.ic_music_classic
                ),
                QuestioningComponent.Item(
                    id = 12,
                    titleId = R.string.questioning_rock,
                    iconId = R.drawable.ic_music_rock
                ),
                QuestioningComponent.Item(
                    id = 13,
                    titleId = R.string.questioning_rap,
                    iconId = R.drawable.ic_music_rap
                ),
                QuestioningComponent.Item(
                    id = 14,
                    titleId = R.string.questioning_guitar,
                    iconId = R.drawable.ic_music_guitar
                ),
                QuestioningComponent.Item(
                    id = 15,
                    titleId = R.string.questioning_pop,
                    iconId = R.drawable.ic_music_pop
                ),
                QuestioningComponent.Item(
                    id = 16,
                    titleId = R.string.questioning_custom,
                    iconId = R.drawable.ic_questioning_custom
                ),
            )
        ),
        QuestioningComponent.Category(
            id = 2,
            titleId = R.string.questioning_type_food,
            data = listOf(
                QuestioningComponent.Item(
                    id = 21,
                    titleId = R.string.questioning_food_home,
                    iconId = R.drawable.ic_food_home
                ),
                QuestioningComponent.Item(
                    id = 22,
                    titleId = R.string.questioning_food_fast,
                    iconId = R.drawable.ic_food_fast
                ),
                QuestioningComponent.Item(
                    id = 23,
                    titleId = R.string.questioning_food_vegan,
                    iconId = R.drawable.ic_food_vegan
                ),
                QuestioningComponent.Item(
                    id = 24,
                    titleId = R.string.questioning_food_asian,
                    iconId = R.drawable.ic_food_asian
                ),
                QuestioningComponent.Item(
                    id = 25,
                    titleId = R.string.questioning_food_italy,
                    iconId = R.drawable.ic_food_italy
                ),
                QuestioningComponent.Item(
                    id = 26,
                    titleId = R.string.questioning_custom,
                    iconId = R.drawable.ic_questioning_custom
                ),
            )
        ),
    )


}