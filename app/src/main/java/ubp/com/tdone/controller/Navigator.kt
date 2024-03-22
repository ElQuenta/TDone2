package ubp.com.tdone.controller

import android.content.Context
import android.content.Intent
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.model.dataclases.Task
import ubp.com.tdone.views.MainActivity.Companion.KEY_NOTE
import ubp.com.tdone.views.MainActivity.Companion.KEY_TASK
import ubp.com.tdone.views.NoteDetailActivity
import ubp.com.tdone.views.TaskDetailActivity

class Navigator(private val context: Context) {
    fun navToNoteDetail(note: Note): Intent {
        val intent = Intent(context, NoteDetailActivity::class.java)
        intent.putExtra(KEY_NOTE, note.id)
        return intent
    }

    fun navToTaskDetail(task: Task): Intent {
        val intent = Intent(context, TaskDetailActivity::class.java)
        intent.putExtra(KEY_TASK, task.id)
        return intent
    }
}