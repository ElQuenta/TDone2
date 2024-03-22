package ubp.com.tdone.views.recyclerViews.showingElements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.model.dataclases.Tag

class TagsAdapter(private var tagList: List<Tag>): RecyclerView.Adapter<TagsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        return  TagsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tag_complete,parent,false)
        )
    }

    override fun getItemCount(): Int = tagList.size

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.bind(tagList[position])
    }
}