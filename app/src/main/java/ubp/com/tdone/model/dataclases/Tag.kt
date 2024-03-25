package ubp.com.tdone.model.dataclases

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import ubp.com.tdone.R

data class Tag(
    @DocumentId
    val id: String,
    val userId : String,
    val name: String,
    val color: Int
){
    constructor() : this(
        id= "",
        userId ="",
        name ="",
        color = R.color.color_tag_1
    )
}
