package ubp.com.tdone.business

import android.content.res.Resources
import android.util.DisplayMetrics

private fun getScreenWidthPixels(): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return displayMetrics.widthPixels
}

private fun pixelsToDp(pixels: Int, displayMetrics: DisplayMetrics): Int {
    return (pixels / displayMetrics.density).toInt()
}

private val screenWidthPixels = getScreenWidthPixels()

fun adaptToScreen(percentage: Double) = (screenWidthPixels * percentage).toInt()
