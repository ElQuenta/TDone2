package ubp.com.tdone.views.recyclerViews.showingElements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.model.dataclases.Note

class NotesAdapter(private var noteList: List<Note>) : RecyclerView.Adapter<NotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(noteList[position])
    }
}