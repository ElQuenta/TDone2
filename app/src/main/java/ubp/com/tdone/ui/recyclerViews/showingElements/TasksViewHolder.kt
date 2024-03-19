package ubp.com.tdone.ui.recyclerViews.showingElements

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.dataBase.dataclases.Tag
import ubp.com.tdone.dataBase.dataclases.Task
import ubp.com.tdone.databinding.ItemTaskBinding

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTaskBinding.bind(view)

    fun bind(task: Task) {
        binding.tvTaskTittle.text = task.title
        binding.tvTaskEndDate.text = task.endDate.toString()
        var position = 1
        task.tag.take(3).forEach {
            printTag(it, position)
            position++
        }


        binding.cbTask.isChecked = task.finished
    }

    private fun printTag(tag: Tag, position: Int) {
        when (position) {
            1 -> {
                binding.tag1.cvTag.apply {
                    setCardBackgroundColor(
                        ContextCompat.getColor(
                            this.context,
                            tag.color
                        )
                    )
                    visibility = View.VISIBLE
                }
            }

            2 -> {
                binding.tag2.cvTag.apply {
                    setCardBackgroundColor(
                        ContextCompat.getColor(
                            this.context,
                            tag.color
                        )
                    )
                    visibility = View.VISIBLE
                }
            }

            3 -> {
                binding.tag3.cvTag.apply {
                    setCardBackgroundColor(
                        ContextCompat.getColor(
                            this.context,
                            tag.color
                        )
                    )
                    visibility = View.VISIBLE
                }
            }
        }
    }

}