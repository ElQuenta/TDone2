package ubp.com.tdone.controller.mediators

import ubp.com.tdone.model.dataclases.Cover
import ubp.com.tdone.views.CreateNoteActivity

object CoverNotesMediator {

    lateinit var createNoteActivity: CreateNoteActivity

    fun setActivity(activity: CreateNoteActivity) {
        createNoteActivity = activity
    }

    fun setCurrentCover(cover: Cover?) {
        createNoteActivity.updateCover(cover)
    }
}