package ubp.com.tdone.views.fragments.menuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ubp.com.tdone.controller.nav.NavNoteDetailCommand
import ubp.com.tdone.controller.nav.Navigator
import ubp.com.tdone.model.noteListExample
import ubp.com.tdone.databinding.FragmentAllNotesBinding
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.views.recyclerViews.showingElements.NotesAdapter


class AllNotesFragment : Fragment() {

    private lateinit var binding: FragmentAllNotesBinding

    private lateinit var allNotesAdapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        allNotesAdapter = NotesAdapter(noteListExample){
            navToNoteDetail(it)
        }
        binding.rvAllNotes.apply {
            layoutManager =
                GridLayoutManager(binding.root.context, 2, GridLayoutManager.VERTICAL, false)
            adapter = allNotesAdapter
        }
    }

    private fun navToNoteDetail(note: Note) {
        startActivity(NavNoteDetailCommand(note, Navigator(binding.root.context)).execute())
    }

}