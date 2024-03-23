package ubp.com.tdone.controller.nav

import android.content.Intent
import ubp.com.tdone.model.dataclases.Task

class NavTaskDetailCommand(private val task: Task,private val navigator: Navigator): Command {
    override fun execute(): Intent = navigator.navToTaskDetail(task)
}