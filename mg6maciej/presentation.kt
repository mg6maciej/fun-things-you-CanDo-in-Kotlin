package mg6maciej

import android.R
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.v4.app.Fragment
import android.view.View
import java.util.*

class Kotlin

class CanDo<T>

fun things(you: CanDo<in Kotlin>) = listOf(
        companionObjects(),
        funcationalProgramming(),
        extensionFunctions(),
        operatorOverload(),
        infixFunc(),
        moreFunctionalProgramming(),
        optionals(),
        multipleInheritance()
)

fun multipleInheritance() {
    class MyClass(val r: Runnable) : List<String> by ArrayList(), Runnable by r
}

fun optionals(arg: String? = null) {

}

fun moreFunctionalProgramming() {
    MyFragment.newInstance("my_arg")
}

fun infixFunc() {
    R.id.text1 matchesWithText R.string.cancel
}

infix private fun Int.matchesWithText(@StringRes cancel: Int) {
    onView(withId(this)).check(matches(withText(cancel)))
}

fun operatorOverload() {
    // NSFW
    operator fun Int.times(operation: () -> Unit) {
        (0..this).forEach { operation() }
    }
    6 * { print("DroidCon") }
    operator fun (() -> Unit).times(count: Int) {
        count * this
    }
    { print("DroidCon") } * 6
}

fun extensionFunctions() {
    fun Int.times(operation: () -> Unit) {
        (0..this).forEach { operation() }
    }
    6.times { print("DroidCon") }

    val view = View(null)
    view.visibility = View.VISIBLE
    view.show()
}

fun funcationalProgramming() {
    (0..6).filter(::isEven).sum()
    (0..6).sumBy { if (isEven(it)) it else 0 }
}

private fun isEven(it: Int) = it % 2 == 0

class MyFragment : Fragment() {

    companion object {

        fun newInstance(arg: String? = null) = MyFragment().applyArgs {
            arg?.let { putString("arg", it) }
        }
    }
}

fun companionObjects() {

    MyFragment.newInstance()
}

// helper functions copied from real project

fun <T : Fragment> T.applyArgs(init: Bundle.() -> Unit) = apply {
    arguments = Bundle().apply(init)
}

fun View.show() { visibility = View.VISIBLE }
