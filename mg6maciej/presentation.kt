package mg6maciej

import android.os.Bundle
import android.support.test.espresso.Espresso
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v4.app.Fragment
import android.view.View
import java.util.*

fun <T : Fragment> T.applyArgs(init: Bundle.() -> Unit) = apply {
    arguments = Bundle().apply(init)
}

fun View.show() {
    visibility = View.VISIBLE
}

class CanDo<T>

class Kotlin

fun things(you: CanDo<in Kotlin>) = listOf(
        ifStatement(),
        forLoop(),
        companions(),
        functionalProgramming(),
        extensions(),
        operatorsOverloading(),
        infixFunc(),
        moreFunctionalProgramming(),
        multipleInheritance()
)

fun multipleInheritance() {
    class MyClass(val r: Runnable) : List<String> by ArrayList(), Runnable by r {

    }
}

fun moreFunctionalProgramming() {
    MyFragment.newInstance("dsa")
}

fun infixFunc() {
    infix fun Int.matchesWithText(strRes: Int) {
        Espresso.onView(ViewMatchers.withId(this))
    }
    R.id.text matchesWithText R.string.abc_action_bar_home_description
}

fun operatorsOverloading() {
    // NSFW
    operator fun Int.times(opeation: () -> Unit) {
        (0..this).forEach { opeation() }
    }
    6 * { print("DevFest") }
    operator fun (() -> Unit).times(count: Int) {
        count * this
    }
    { print("DevFest") } * 6
}

val Int.isOdd: Boolean
    get() = this % 2 == 1

fun extensions() {
    fun Int.isEven(): Boolean = this % 2 == 0
    (1..6).sumBy { if (it.isOdd) it else 0 }

    fun Int.times(opeation: () -> Unit) {
        (0..this).forEach { opeation() }
    }
    6.times { print("DevFest") }
    val view = View(null)
    view.show()
}

fun functionalProgramming() {
    listOf(1, 2).filter { it % 2 == 0 }.sum()
    (1..6).sumBy { if (it % 2 == 0) it else 0 }
}

fun companions() {
    MyFragment.newInstance()
}

class MyFragment : Fragment() {

    companion object {

        fun newInstance(): Fragment {
            return MyFragment()
        }

        fun newInstance(arg: String) = MyFragment().applyArgs {
            putString("arg", arg)
        }
    }
}

fun forLoop() {
    for (i in 0..6) {

    }
}

fun ifStatement() {
    val x = if (true) 3 else 1
}
