package ubp.com.tdone.model

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.model.dataclases.Task

object DBConection {
    private val db = FirebaseFirestore.getInstance()

    suspend fun createTask(task: Task): String? {
        return db.collection("tasks").add(task).continueWith {
            it.result?.id
        }.await()
    }

    suspend fun getTasksForUser(userId: String): List<Task> {
        return db.collection("tasks")
            .whereEqualTo("userId", userId)
            .get()
            .await()
            .documents
            .map { it.toObject(Task::class.java)!! }
    }

    suspend fun getTask(taskId: String): Task? {
        return db.collection("tasks")
            .document(taskId)
            .get()
            .await()
            .toObject(Task::class.java)
    }

    suspend fun deleteTask(taskId: String) {
        db.collection("tasks").document(taskId).delete().await()
    }

    suspend fun createNote(note: Note): String? {
        return db.collection("notes").add(note).continueWith {
            it.result?.id
        }.await()
    }

    suspend fun getNotesForUser(userId: String): List<Task> {
        return db.collection("notes")
            .whereEqualTo("userId", userId)
            .get()
            .await()
            .documents
            .map { it.toObject(Task::class.java)!! }
    }

    suspend fun getNote(noteId: String): Task? {
        return db.collection("notes")
            .document(noteId)
            .get()
            .await()
            .toObject(Task::class.java)
    }

    suspend fun deleteNote(noteId: String) {
        db.collection("notes").document(noteId).delete().await()
    }

    suspend fun createTag(tag: Tag): String? {
        return db.collection("tags").add(tag).continueWith {
            it.result?.id
        }.await()
    }

    suspend fun getTagsForUser(userId: String): List<Task> {
        return db.collection("tags")
            .whereEqualTo("userId", userId)
            .get()
            .await()
            .documents
            .map { it.toObject(Task::class.java)!! }
    }

    suspend fun getTag(tagId: String): Task? {
        return db.collection("tags")
            .document(tagId)
            .get()
            .await()
            .toObject(Task::class.java)
    }

    suspend fun deleteTag(tagId: String) {
        db.collection("tags").document(tagId).delete().await()
    }


}