package pl.mg6maciej.funthingsyoucandoinkotlin.ui

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

@Suppress("UNCHECKED_CAST")
fun <T : View> Activity.find(@IdRes viewId: Int) = lazy(LazyThreadSafetyMode.NONE) { findViewById(viewId) as T }
