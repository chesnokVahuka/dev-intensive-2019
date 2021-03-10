package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_factory() {
        val user = User.Factory.makeUser("Холод Александр")

        println(user)
    }

    @Test
    fun test_abstract_factory() {
        val user = User.Factory.makeUser("Холод Александр")
        val chat = Chat("1")

        val txtMessage = BaseMessage.AbstractFactory.makeMessage(user,chat, date = Date().add(-2, TimeUnits.DAY),payload = "lorem ipsum",type = "text",)
        val imgMessage = BaseMessage.AbstractFactory.makeMessage(user,chat, date = Date(),payload = "url/img.png",type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())

        when(imgMessage){
            is TextMessage -> txtMessage.formatMessage()
            is ImageMessage -> imgMessage.formatMessage()
        }
    }

    @Test
    fun test_user() {
        val user = User.Factory.makeUser("Холод Александр")

        println(user.lastVisit?.format())
    }

    @Test
    fun test_date() {
        val msgDate = Date().add(-361, TimeUnits.DAY)
        val diff:Long = Date().time - msgDate.time

        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24

        when(diff / 1000){
            0L,1L -> println("только что")
            in 1L..45L -> println("несколько секунд назад")
            in 45L..75L -> println("минуту назад")
            in 75L..45L*60 -> println(" ${diff / 1000 / 60} минут назад")
            in 45L*60..75L*60 -> println(" час назад")
            in 75L*60..22L*60*60 -> println("  ${diff / 1000 / 60 / 60} часов назад")
            in 22L*60*60..26L*60*60 -> println("день назад")
            in 26L*60*60..360L*60*60*24 -> println("  ${diff / 1000 / 60 / 60 / 24} дней назад")
            else -> println("более года назад")
        }
        println("${diff / 1000}")
    }

    @Test
    fun test_fullName() {
        val user = User.Factory.makeUser("Холод")

        println(user)
    }


    @Test
    fun test_initials() {
        println(Utils.toInitials("Александр",""))
    }

    @Test
    fun test_translit() {
       println(Utils.transliteration("Холод Александр"))
    }

    @Test
    fun test_userBuilder() {
        val user = User.Builder().id("1").firstName("Александр").build()
        println(user)
    }


}