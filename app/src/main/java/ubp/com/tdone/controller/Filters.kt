package ubp.com.tdone.controller

import ubp.com.tdone.model.dataclases.*

object Filters {
    fun filterNoteById(notes: List<Note>, id: String): Note? {
        return notes.find { note -> note.id == id }
    }

    fun filterTaskById(tasks: List<Task>, id: String): Task? {
        return tasks.find { task -> task.id == id }
    }

    fun filterTagById(tasks: List<Task>, id: String): Task? {
        return tasks.find { task -> task.id == id }
    }

}