package ubp.com.tdone.controller

import android.content.res.Resources
import android.util.DisplayMetrics

private fun getScreenWidthPixels(): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return displayMetrics.widthPixels
}

fun dpToPixel(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}

fun adaptToScreen(percentage: Double) = (getScreenWidthPixels() * percentage).toInt()
