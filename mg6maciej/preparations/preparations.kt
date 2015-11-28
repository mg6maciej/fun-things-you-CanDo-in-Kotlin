package mg6maciej.preparations

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import java.util.*

fun <T : Fragment> T.applyArgs(init: Bundle.() -> Unit) = apply {
    arguments = Bundle().apply(init)
}

@Suppress("UNCHECKED_CAST")
fun <T : View> Activity.find(@IdRes id: Int) = lazy(LazyThreadSafetyMode.NONE) { findViewById(id) as T }

class Kotlin

class CanDo<T>

fun things(you: CanDo<in Kotlin>) = listOf(
        ifStatement(),
        forLoops(),
        companions(),
        functionalProgramming(),
        extensions(),
        operatorOverloading(),
        infixFunctions(),
        moreFunctionalProgramming(),
        optionals(),
        laziness(),
        multipleInheritance()
)

fun multipleInheritance() {
    class MyClass(val r: Runnable) : List<String> by ArrayList(), Runnable by r {

    }
}

fun laziness() {
    val x = lazy { 6 * 6 * 6 * 6 * 6 * 6 }
    x.value
}

fun optionals(int: Int = 4) {
    val str: String? = null
    str?.toLowerCase()
}

class MyActivity : Activity() {

    private var myView: TextView? = null
    private val myOtherView by find<TextView>(R.id.action0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.abc_action_bar_view_list_nav_layout)
        myView = findViewById(R.id.action0) as TextView
        myView!!.text = ""
        myOtherView.text = ""
    }
}

fun moreFunctionalProgramming() {
    MyFragment.newInstance("arg")
}

fun infixFunctions() {
    infix fun Int.matchesWithText(@StringRes strRes: Int) {
        Espresso.onView(ViewMatchers.withId(this)).check(ViewAssertions.matches(ViewMatchers.withText(strRes)))
    }
    R.id.text matchesWithText R.string.abc_action_bar_home_description
}

fun operatorOverloading() {
    operator fun Int.times(operation: () -> Unit) {
        (1..this).forEach { operation() }
    }
    6 * { print("times") }
    operator fun (() -> Unit).times(count: Int) {
        count * this
    }
    // NSFW
    { print("something") } * 4
    ::extensions * 3
}

val Int.isOdd: Boolean get() = this % 2 == 1
fun extensions() {
    fun Int.isEven() = this % 2 == 0
    (0..100).filter(Int::isEven).sum()
    (0..100).sumBy { if (it.isOdd) it else 0 }

    fun Int.times(operation: () -> Unit) {
        (1..this).forEach { operation() }
    }
    6.times { print("times") }
    val view = View(null)
    fun View.show() {
        visibility = View.VISIBLE
    }
    view.show()
}

fun functionalProgramming() {
    val even: (Int) -> Boolean = { it % 2 == 0 }
    (0..100).filter(even).sum()
    (0..100).sumBy { if (it % 2 == 0) it else 0 }
}

fun companions() {
    MyFragment.newInstance()
}

class MyFragment : Fragment() {

    companion object {

        fun newInstance(arg: String? = null) = MyFragment().applyArgs {
            arg?.let { putString("arg", it) }
        }
    }
}

fun forLoops() {
    for (i in 0..100) {
    }
}

fun ifStatement() {
    val x = if (true) 1 else 2
}
