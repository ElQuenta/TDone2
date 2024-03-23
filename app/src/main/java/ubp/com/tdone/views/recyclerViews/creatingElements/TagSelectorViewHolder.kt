package ubp.com.tdone.views.recyclerViews.creatingElements

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.controller.dpToPixel
import ubp.com.tdone.databinding.ItemSelectionTagBinding
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.views.fragments.creationItemFragments.SelectTagsFragment.Companion.NEW_TAG_ID

class TagSelectorViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSelectionTagBinding.bind(view)

    fun bind(tag: Tag, createTag: () -> Unit, onPressTag: (Tag, Boolean) -> Unit) {
        binding.cvTag.setCardBackgroundColor(
            ContextCompat.getColor(
                binding.root.context,
                tag.color
            )
        )
        binding.tvTagName.text = tag.name
        if (tag.id.equals(NEW_TAG_ID)) {
            binding.cbSelectTag.visibility = View.GONE
            binding.cvTag.setOnClickListener {
                createTag()
            }
            binding.tvTagName.text
            binding.cvTag.layoutParams.width = dpToPixel(260)
        }
        binding.cbSelectTag.setOnCheckedChangeListener { _, checked->
            onPressTag(tag,checked)
        }
    }
}