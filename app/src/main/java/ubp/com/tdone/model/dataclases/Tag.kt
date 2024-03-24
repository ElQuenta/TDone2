package ubp.com.tdone.model.dataclases

import com.google.firebase.firestore.DocumentId

data class Tag(
    @DocumentId
    val id: String,
    val userId : String,
    val name: String,
    val color: Int
)
