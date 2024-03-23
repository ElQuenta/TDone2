package ubp.com.tdone.views.recyclerViews.creatingElements

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ItemColorBinding

class ColorViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemColorBinding.bind(view)

    fun bind(color: Int, comparateColor: (Int) -> Boolean) {
        binding.color.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,color))
        binding.root.setCardBackgroundColor(
            ContextCompat.getColor(
                binding.root.context,
                if (comparateColor(color)) {
                    R.color.item_selected_background
                } else {
                    R.color.black
                }
            )
        )
    }
}