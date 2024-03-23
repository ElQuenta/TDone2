package ubp.com.tdone.controller.mediators

import android.app.Activity
import ubp.com.tdone.views.CreateNoteActivity

object ColorActivityMediator : CreationMediator {
    private var isNoteCreator = true
    var colorList: List<Int> = listOf()
    private lateinit var noteCreator: CreateNoteActivity

    override fun setActivity(activity: Activity, isNoteCreator: Boolean) {
        this.isNoteCreator = isNoteCreator
        if (isNoteCreator) {
            noteCreator = activity as CreateNoteActivity
        }
    }

    fun initColorList(colorList: List<Int>) {
        this.colorList = colorList
    }

    fun setCurrentColor(color: Int) {
        if (isNoteCreator) {
            noteCreator.updateBackground(color)
        } else {

        }
    }


}