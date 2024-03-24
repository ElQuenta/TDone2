package ubp.com.tdone.controller.mediators

import ubp.com.tdone.views.CreateTaskActivity
import java.util.Date

object DateActivityMediator {

    private lateinit var createTask: CreateTaskActivity
    var date: Date = Date()

    fun setActivity(activity: CreateTaskActivity) {
        createTask = activity
    }

    fun initDate(date: Date) {
        this.date = date
        createTask.updateDate(date)
    }


}