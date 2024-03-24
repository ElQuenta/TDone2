package ubp.com.tdone.controller.mediators

import android.app.Activity
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.views.CreateNoteActivity
import ubp.com.tdone.views.CreateTaskActivity

object TagActivityMediator : CreationMediator {

    private var isNoteCreator = true
    private lateinit var noteCreator: CreateNoteActivity
    private lateinit var taskCreator: CreateTaskActivity
    var tagList = mutableListOf<Tag>()

    override fun setActivity(activity: Activity, isNoteCreator: Boolean) {
        this.isNoteCreator = isNoteCreator
        if (isNoteCreator) {
            noteCreator = activity as CreateNoteActivity
        } else {
            taskCreator = activity as CreateTaskActivity
        }
    }

    fun initTagList(tagList: MutableList<Tag>){
        this.tagList=tagList
        if (isNoteCreator){
            noteCreator.updateTagList(tagList)
        }else{
            taskCreator.updateTagList(tagList)
        }
    }

}