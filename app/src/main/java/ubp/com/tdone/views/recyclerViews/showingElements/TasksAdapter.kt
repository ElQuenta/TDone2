package ubp.com.tdone.views.recyclerViews.showingElements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ubp.com.tdone.R
import ubp.com.tdone.model.dataclases.Task

class TasksAdapter(private var taskList: List<Task>, private val nav: (Task) -> Unit) : RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        return TasksViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        )
    }

    override fun getItemCount(): Int = taskList.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.bind(taskList[position],nav)
    }
}