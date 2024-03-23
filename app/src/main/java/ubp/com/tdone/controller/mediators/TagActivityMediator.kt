package ubp.com.tdone.controller.mediators

import android.app.Activity
import ubp.com.tdone.model.dataclases.Tag

interface TagActivityMediator {

    fun setActivity(activity: Activity)
    fun setCurrentTagList(tagList: MutableList<Tag>)

}