package ubp.com.tdone.views.recyclerViews.creatingElements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.model.dataclases.Tag

class TagSelectorAdapter(
    private val tagList: MutableList<Tag>,
    private val createTag: () -> Unit,
    private val onPressTag: (Tag, Boolean) -> Unit,
    private val compareTags: (Tag)->Boolean
) :
    RecyclerView.Adapter<TagSelectorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagSelectorViewHolder {
        return TagSelectorViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_selection_tag, parent, false)
        )
    }

    override fun getItemCount(): Int = tagList.size

    override fun onBindViewHolder(holder: TagSelectorViewHolder, position: Int) {
        holder.bind(tagList[position],createTag,onPressTag,compareTags)
    }
}