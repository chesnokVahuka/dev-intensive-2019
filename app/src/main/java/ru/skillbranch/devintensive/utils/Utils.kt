package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?): Pair<String?, String?> {

        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return Pair(firstName, lastName)
    }

    fun toInitials (firstName: String?, lastName:String?) : String? {
        val firstChar:Char? = firstName?.getOrNull(0)?.toUpperCase()?:' '
        val lastChar:Char? = lastName?.getOrNull(0)?.toUpperCase()?:' '

        return "$firstChar$lastChar"
    }

    fun transliteration(payload:String, divider:String = " ") : String {
        var translit = ""
        payload.forEach {
            when(it){
                'а','А' -> {
                    translit += if(it.isUpperCase()) "A" else "a"
                }
                'б','Б' -> {
                    translit += if(it.isUpperCase()) "B" else "b"
                }
                'в','В' -> {
                    translit += if(it.isUpperCase()) "V" else "v"
                }
                'г','Г' -> {
                    translit += if(it.isUpperCase()) "G" else "g"
                }
                'д','Д' -> {
                    translit += if(it.isUpperCase()) "D" else "d"
                }
                'е','Е' -> {
                    translit += if(it.isUpperCase()) "E" else "e"
                }
                'ё','Ё' -> {
                    translit += if(it.isUpperCase()) "E" else "e"
                }
                'ж','Ж' -> {
                    translit += if(it.isUpperCase()) "Zh" else "zh"
                }
                'з','З' -> {
                    translit += if(it.isUpperCase()) "Z" else "z"
                }
                'и','И' -> {
                    translit += if(it.isUpperCase()) "I" else "i"
                }
                'к','К' -> {
                    translit += if(it.isUpperCase()) "K" else "k"
                }
                'л','Л' -> {
                    translit += if(it.isUpperCase()) "L" else "l"
                }
                'м','М' -> {
                    translit += if(it.isUpperCase()) "M" else "m"
                }
                'н','Н' -> {
                    translit += if(it.isUpperCase()) "N" else "n"
                }
                'о','О' -> {
                    translit += if(it.isUpperCase()) "O" else "o"
                }
                'п','П' -> {
                    translit += if(it.isUpperCase()) "P" else "p"
                }
                'р','Р' -> {
                    translit += if(it.isUpperCase()) "R" else "r"
                }
                'с','С' -> {
                    translit += if(it.isUpperCase()) "S" else "s"
                }
                'т','Т' -> {
                    translit += if(it.isUpperCase()) "T" else "t"
                }
                'у','У' -> {
                    translit += if(it.isUpperCase()) "U" else "u"
                }
                'ф','Ф' -> {
                    translit += if(it.isUpperCase()) "F" else "f"
                }
                'х','Х' -> {
                    translit += if(it.isUpperCase()) "H" else "h"
                }
                'ц','Ц' -> {
                    translit += if(it.isUpperCase()) "C" else "c"
                }
                'ч','Ч' -> {
                    translit += if(it.isUpperCase()) "Ch" else "ch"
                }
                'ш','Ш' -> {
                    translit += if(it.isUpperCase()) "Sh" else "sh"
                }
                'щ','Щ' -> {
                    translit += if(it.isUpperCase()) "Sh" else "sh"
                }
                'ы','Ы' -> {
                    translit += if(it.isUpperCase()) "I" else "i"
                }
                'э','Э' -> {
                    translit += if(it.isUpperCase()) "E" else "e"
                }
                'ю','Ю' -> {
                    translit += if(it.isUpperCase()) "Yu" else "yu"
                }
                'я','Я' -> {
                    translit += if(it.isUpperCase()) "Ya" else "ya"
                }
                else -> translit += divider
            }
        }

        return  translit
    }

}