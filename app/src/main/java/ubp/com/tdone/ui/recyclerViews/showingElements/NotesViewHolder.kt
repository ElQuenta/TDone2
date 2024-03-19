package ubp.com.tdone.ui.recyclerViews.showingElements

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.business.adaptToScreen
import ubp.com.tdone.dataBase.dataclases.Note
import ubp.com.tdone.databinding.ItemNoteBinding

class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNoteBinding.bind(view)
    fun bind(note: Note) {
        binding.root.setCardBackgroundColor(
            ContextCompat.getColor(binding.root.context, note.background)
        )
        binding.tvNoteTittle.text = note.title
        if (note.cover != null) {
            val cover = note.cover
            if (cover.src!= null && cover.srcImage){
                binding.ivFrontNote.setImageResource(cover.src!!)
            }else if (cover.uri != null){
                binding.ivFrontNote.setImageURI(cover.uri)
            }
        }

        binding.root.layoutParams.width = adaptToScreen(0.4)
    }

}