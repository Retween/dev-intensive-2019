package ru.skillbranch.devintensive.utilits

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //TO DO fix
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return ""
    }
}