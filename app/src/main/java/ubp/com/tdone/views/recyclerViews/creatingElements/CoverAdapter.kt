package ubp.com.tdone.views.recyclerViews.creatingElements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.model.dataclases.Cover

class CoverAdapter(
    private val coverList: List<Cover>,
    private val compare: (Cover) -> Boolean,
    private val changeCurrentCover: (Cover) -> Unit
) :
    RecyclerView.Adapter<CoverViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoverViewHolder {
        return CoverViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cover, parent, false)
        )
    }

    override fun getItemCount(): Int = coverList.size

    override fun onBindViewHolder(holder: CoverViewHolder, position: Int) {
        holder.bind(coverList[position], compare)
        holder.itemView.setOnClickListener {
            changeCurrentCover(coverList[position])
        }
    }
}