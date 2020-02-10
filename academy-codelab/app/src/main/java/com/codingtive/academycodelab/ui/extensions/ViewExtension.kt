package com.codingtive.academycodelab.ui.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutResource: Int): View {
    return LayoutInflater.from(context).inflate(layoutResource, this, false)
}

fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}
