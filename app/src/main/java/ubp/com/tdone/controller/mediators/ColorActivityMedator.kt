package ubp.com.tdone.controller.mediators

import android.app.Activity
import ubp.com.tdone.views.fragments.creationItemFragments.SelectColorFragment

interface ColorActivityMedator {

    fun setActivity(activity: Activity)
    fun setColorList(colorList: List<Int>)
    fun setCurrentColor(color: Int)

}