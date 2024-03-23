package ubp.com.tdone.views.fragments.menuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.controller.nav.NavNoteDetailCommand
import ubp.com.tdone.controller.nav.NavTaskDetailCommand
import ubp.com.tdone.controller.nav.Navigator
import ubp.com.tdone.databinding.FragmentHomeBinding
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.model.dataclases.Task
import ubp.com.tdone.model.noteListExample
import ubp.com.tdone.model.taskListExample
import ubp.com.tdone.views.recyclerViews.showingElements.NotesAdapter
import ubp.com.tdone.views.recyclerViews.showingElements.TasksAdapter

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
        notesAdapter = NotesAdapter(noteListExample.take(4)) {
            navToNoteDetail(it)
        }
        binding.rvCurrentNotes.apply {
            layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = notesAdapter
        }

        tasksAdapter = TasksAdapter(taskListExample) {
            navToTaskDetail(it)
        }
        binding.rvNearToEndTasks.apply {
            layoutManager =
                LinearLayoutManager(binding.root.context)
            adapter = tasksAdapter
        }
    }

    private fun navToNoteDetail(note: Note) {
        startActivity(NavNoteDetailCommand(note, Navigator(binding.root.context)).execute())
    }

    private fun navToTaskDetail(task: Task) {
        startActivity(NavTaskDetailCommand(task, Navigator(binding.root.context)).execute())
    }

}