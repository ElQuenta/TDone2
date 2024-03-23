package ubp.com.tdone.controller.mediators

import android.app.Activity
import ubp.com.tdone.model.dataclases.Cover
import ubp.com.tdone.views.CreateNoteActivity

object CoverNotesMediator {

    lateinit var createNoteActivity: CreateNoteActivity

    fun setActivity(activity: Activity) {
        createNoteActivity = activity as CreateNoteActivity
    }

    fun setCurrentCover(cover: Cover?) {
        createNoteActivity.updateCover(cover)
    }
}