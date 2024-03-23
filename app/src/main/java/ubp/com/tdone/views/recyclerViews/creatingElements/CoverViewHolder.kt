package ubp.com.tdone.views.recyclerViews.creatingElements

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ItemCoverBinding
import ubp.com.tdone.model.dataclases.Cover

class CoverViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCoverBinding.bind(view)

    fun bind(cover: Cover, compare: (Cover) -> Boolean) {
        if (cover.srcImage && cover.src != null) {
            binding.ivFrontNote.setImageResource(cover.src!!)
        } else if (cover.uri != null) {
            binding.ivFrontNote.setImageURI(cover.uri)
        }
        if (compare(cover)) {
            binding.root.setCardBackgroundColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.item_selected_background
                )
            )
        }else{
            binding.root.setCardBackgroundColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.black
                )
            )
        }

    }
}