package ubp.com.tdone.model.dataclases

import android.net.Uri
import com.google.firebase.firestore.DocumentId


data class Cover(
    @DocumentId
    val id: String,
    val userId : String,
    var src: Int? = null,
    var uri: Uri? = null,
    var srcImage: Boolean = true
)