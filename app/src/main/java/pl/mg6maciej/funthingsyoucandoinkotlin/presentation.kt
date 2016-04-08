package pl.mg6maciej.funthingsyoucandoinkotlin

import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import pl.mg6maciej.funthingsyoucandoinkotlin.animals.HumanEatingCreature
import pl.mg6maciej.funthingsyoucandoinkotlin.animals.Lion
import pl.mg6maciej.funthingsyoucandoinkotlin.animals.Person
import pl.mg6maciej.funthingsyoucandoinkotlin.animals.RiddleLovingCreature

fun things(you: CanDo<in Kotlin>) = listOf(
        extensionFunctions(),
        operatorOverloading(),
        multipleInheritance(),
        infixFunctions()
)

fun infixFunctions() {
    infix fun Int.hasText(@StringRes res: Int) {
        onView(withId(this))
                .check(matches(withText(res)))
    }
    onView(withId(R.id.text_view))
            .check(matches(withText(R.string.app_name)))
    R.id.text_view hasText R.string.app_name
}

fun multipleInheritance() {
    class Sphinx : RiddleLovingCreature by Person("sphinx")
            , HumanEatingCreature by Lion() {

        override fun reactToWrongAnswer(from: Person) {
            eat(from)
        }
    }
}

fun operatorOverloading() {
    // NSFW
    operator fun Int.times(operation: () -> Unit) {
        (1..this).forEach { operation() }
    }

    operator fun (() -> Unit).times(count: Int) {
        count * this
    }

    operator fun Int.plus(operation: () -> Unit) {

    }
    6 * { println("DroidCon") }
    6 + {}
    { println("DroidCon") } * 6
}

fun extensionFunctions() {
    fun Int.times(operation: () -> Unit) {
        (1..this).forEach { operation() }
    }
    6.times { println("DroidCon") }
}

class CanDo<T>

class Kotlin