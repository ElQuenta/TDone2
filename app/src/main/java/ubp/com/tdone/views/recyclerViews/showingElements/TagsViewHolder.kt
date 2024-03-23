package ubp.com.tdone.views.recyclerViews.showingElements

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.databinding.ItemTagCompleteBinding
import ubp.com.tdone.model.dataclases.Tag

class TagsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTagCompleteBinding.bind(view)

    fun bind(tag: Tag) {
        binding.root.setCardBackgroundColor(
            ContextCompat.getColor(
                binding.root.context,
                tag.color
            )
        )
        binding.tvTagName.text = tag.name
    }
}