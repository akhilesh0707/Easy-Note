package com.aqube.notes.core.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.getVersionName(): String = packageManager.getPackageInfo(packageName, 0).versionName


inline fun Context.openWebPage(url: String, onCantHandleAction: () -> Unit = {}) {
    val webpage: Uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, webpage)
    try {
        startActivity(intent)
    } catch (t: Throwable) {
        onCantHandleAction()
    }
}