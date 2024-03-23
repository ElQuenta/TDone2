package ubp.com.tdone.views.fragments.menuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.controller.nav.NavTaskDetailCommand
import ubp.com.tdone.controller.nav.Navigator
import ubp.com.tdone.model.taskListExample
import ubp.com.tdone.databinding.FragmentAllTasksBinding
import ubp.com.tdone.model.dataclases.Task
import ubp.com.tdone.views.recyclerViews.showingElements.TasksAdapter

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
        allTasksAdapter = TasksAdapter(taskListExample){
            navToTaskDetail(it)
        }
        binding.rvAllTasks.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = allTasksAdapter
        }
    }

    private fun navToTaskDetail(task: Task) {
        startActivity(NavTaskDetailCommand(task, Navigator(binding.root.context)).execute())
    }
}