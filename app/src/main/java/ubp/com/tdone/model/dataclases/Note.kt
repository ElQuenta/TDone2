package ubp.com.tdone.model.dataclases

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp

data class Note(
    @DocumentId
    val id: String,
    val userId : String,
    val title: String,
    val body: String? = null,
    val tags: List<Tag> = emptyList(),
    val cover: Cover? = null,
    val background: Int,
    @ServerTimestamp
    val createdAt: Timestamp? = null,
    @ServerTimestamp
    val updatedAt: Timestamp? = null
)