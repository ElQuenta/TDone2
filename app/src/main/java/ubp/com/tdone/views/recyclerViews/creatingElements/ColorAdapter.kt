package ubp.com.tdone.views.recyclerViews.creatingElements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R

class ColorAdapter(
    private val colorList: List<Int>,
    private val changeCurrentColor: (Int) -> Unit,
    private val comparateColor: (Int)->Boolean
) : RecyclerView.Adapter<ColorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun getItemCount(): Int = colorList.size

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colorList[position],comparateColor)
        holder.itemView.setOnClickListener {
            changeCurrentColor(colorList[position])
        }
    }
}