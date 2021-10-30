package com.aqube.notes.core.util

import android.content.Context

fun Context.getVersionName(): String = packageManager.getPackageInfo(packageName, 0).versionName
