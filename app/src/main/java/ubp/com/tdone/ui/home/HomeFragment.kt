package ubp.com.tdone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.dataBase.noteListExample
import ubp.com.tdone.dataBase.taskListExample
import ubp.com.tdone.databinding.FragmentHomeBinding
import ubp.com.tdone.ui.recyclerViews.showingElements.NotesAdapter
import ubp.com.tdone.ui.recyclerViews.showingElements.TasksAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var notesAdapter: NotesAdapter
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        notesAdapter = NotesAdapter(noteListExample.take(4))
        binding.rvCurrentNotes.apply {
            layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = notesAdapter
        }

        tasksAdapter = TasksAdapter(taskListExample)
        binding.rvNearToEndTasks.apply {
            layoutManager =
                LinearLayoutManager(binding.root.context)
            adapter = tasksAdapter
        }
    }

}