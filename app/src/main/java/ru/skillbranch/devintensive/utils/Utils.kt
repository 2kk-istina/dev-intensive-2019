package ru.skillbranch.devintensive.utils


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{

        var firstName: String?
        var lastName: String?

        val parts : List<String>? = fullName?.split(" ")

        if (fullName == " "&&fullName == "") {
            firstName = "null"
            lastName = "null"
        } else if (parts?.getOrNull(1) == null||parts?.getOrNull(1) == ""||parts?.getOrNull(1) == " ") {
            firstName = parts?.getOrNull(0) as String
            lastName = "null"
        } else if (parts?.getOrNull(0) == null||parts?.getOrNull(0) == ""||parts?.getOrNull(0) == " ") {
            firstName = "null"
            lastName = parts?.getOrNull(1) as String
        } else {
                firstName =parts.getOrNull(0) as String
                lastName =parts.getOrNull(1) as String
        }
        return Pair(firstName, lastName)
    }


    fun toInitials(firstName: String?, lastName: String?): String {

        val initials: String?
        val temp: Char?
        val temp1: Char?

        if (firstName == "null" && lastName == "null") {
            initials = "null"
        } else if (firstName == " " && lastName == " ") {
            initials = "null"
        } else if (firstName == " " || lastName == "") {
            initials = "null"
        } else if (firstName == "null") {
            temp = lastName!![1]
            initials = temp.toString().toUpperCase()
        } else if (lastName == "null") {
            temp = firstName!![0]
            initials = temp.toString().toUpperCase()
        } else {
            temp = firstName!![0]
            temp1 = lastName!![0]
            initials = temp+temp1.toString().toUpperCase()
        }
        return initials.toUpperCase()
    }

    fun transliteration(payload: String, divider: String = " "): String {

        var nameX = payload.toLowerCase()

        val letters: Map<Char, String> = mapOf(
            'а' to "a", 'б' to "b",
            'в' to "v", 'г' to "g",
            'д' to "d", 'е' to "e",
            'ё' to "e", 'ж' to "zh",
            'з' to "z", 'и' to "i",
            'й' to "i", 'к' to "k",
            'л' to "l", 'м' to "m",
            'н' to "n", 'о' to "o",
            'р' to "r", 'п' to "p",
            'с' to "s", 'т' to "t",
            'у' to "u", 'ф' to "f",
            'х' to "h", 'ц' to "c",
            'ч' to "ch", 'ш' to "sh",
            'щ' to "sh'", 'ъ' to "",
            'ы' to "i", 'ь' to "",
            'э' to "e", 'ю' to "yu",
            'я' to "ya", ' ' to " ")

        var result = ""
        var resultX = ""

        for (char in nameX) {
            if (letters.containsKey(char) )
                result += letters.getValue(char)
            else {
                resultX +=char
            }
        }

        val parts : List<String>? = result?.split(" ")
        val firstName =parts?.getOrNull(0)?.capitalize()
        val lastName =parts?.getOrNull(1)?.capitalize()

       // println(resultX.capitalize() + divider + result.capitalize())

    return firstName + divider + lastName
    }

}