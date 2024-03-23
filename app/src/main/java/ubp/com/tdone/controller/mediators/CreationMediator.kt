package ubp.com.tdone.controller.mediators

import android.app.Activity

interface CreationMediator {
    fun setActivity(activity: Activity, isNoteCreator: Boolean)
}