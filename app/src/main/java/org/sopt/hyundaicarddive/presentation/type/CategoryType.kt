package org.sopt.hyundaicarddive.presentation.type

enum class CategoryType(
    val description: String
) {
    TOTAL(
        description = "전체"
    ),
    DESIGN(
        description = "디자인·아트"
    ),
    BUILDING(
        description = "건축·인테리어"
    ),
    TRIP(
        description = "여행"
    ),
    MUSIC(
        description = "음악"
    ),
    COOKING(
        description = "쿠킹·고메"
    ),
    STYLE(
        description = "스타일"
    ),
    TECH(
        description = "테크"
    ),
    SPECIAL(
        description = "스페셜"
    );

    companion object{
        fun fromValue(value: String): CategoryType {
            return entries.firstOrNull { it.name.equals(value, ignoreCase = true) }
                ?: TOTAL
        }
    }
}
