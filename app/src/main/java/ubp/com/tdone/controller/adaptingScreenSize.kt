package ubp.com.tdone.controller

import android.content.res.Resources
import android.util.DisplayMetrics

private fun getScreenWidthPixels(): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return displayMetrics.widthPixels
}

private fun pixelsToDp(pixels: Int, displayMetrics: DisplayMetrics): Int {
    return (pixels / displayMetrics.density).toInt()
}

fun adaptToScreen(percentage: Double) = (getScreenWidthPixels() * percentage).toInt()
