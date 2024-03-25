package ubp.com.tdone.model.dataclases

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Task(
    @DocumentId
    val id: String,
    val userId: String,
    val title: String,
    val description: String? = null,
    val finished: Boolean = false,
    val endDate: Date? = null,
    val tag: List<Tag> = emptyList(),
    @ServerTimestamp
    val createdAt: Timestamp? = null,
    @ServerTimestamp
    val updatedAt: Timestamp? = null
) {
    constructor() : this(
        id = "",
        userId = "",
        title = "",
        description = "",
        finished = false,
        endDate = Date(),
        tag = listOf(),
        createdAt = Timestamp.now(),
        updatedAt = Timestamp.now()
    )
}