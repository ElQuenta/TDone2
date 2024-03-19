package ubp.com.tdone.ui.allTasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.dataBase.taskListExample
import ubp.com.tdone.databinding.FragmentAllTasksBinding
import ubp.com.tdone.ui.recyclerViews.showingElements.TasksAdapter

class AllTasksFragment : Fragment() {

    private lateinit var binding: FragmentAllTasksBinding

    private lateinit var allTasksAdapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        allTasksAdapter = TasksAdapter(taskListExample)
        binding.rvAllTasks.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = allTasksAdapter
        }
    }
}