package ubp.com.tdone.controller.mediators

import android.app.Activity
import ubp.com.tdone.model.dataclases.Cover
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.views.CreateNoteActivity
import ubp.com.tdone.views.fragments.creationItemFragments.SelectColorFragment

object CreateNotesMediator : ColorActivityMedator, TagActivityMediator {

    lateinit var createNoteActivity: CreateNoteActivity
    lateinit var colorSet: List<Int>

    override fun setActivity(activity: Activity) {
        createNoteActivity = activity as CreateNoteActivity
    }

    override fun setCurrentTagList(tagList: MutableList<Tag>) {
        createNoteActivity.updateTagList(tagList)
    }

    override fun setColorList(colorList: List<Int>) {
        colorSet = colorList
    }

    override fun setCurrentColor(color: Int) {
        createNoteActivity.updateBackground(color)
    }

    fun setCurrentCover(cover: Cover) {
        createNoteActivity.updateCover(cover)
    }
}