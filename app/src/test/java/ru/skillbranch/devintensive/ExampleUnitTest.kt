package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
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
    fun test_instance() {
        val user2 = User("2", "John", "Wick")
    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("Ivan Grozniy")
//        val user2 = User.makeUser("John Wick")
        val user = User.makeUser("Karen Shahnar")
        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())


        print("$user \n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()
        println("${user.component1()} ${user.component2()} ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.HOUR))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.SECOND))

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent()
        )

    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("MR Krabs")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)

        val userView = newUser.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Karen Wide")
        val txtMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "dsf sdf s", type = "text")
        val imgMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "img.url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}