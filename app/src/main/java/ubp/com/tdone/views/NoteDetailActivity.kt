package ubp.com.tdone.views

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.controller.Filters
import ubp.com.tdone.databinding.ActivityNoteDetailBinding
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.model.noteListExample
import ubp.com.tdone.views.MainActivity.Companion.KEY_NOTE
import ubp.com.tdone.views.recyclerViews.showingElements.TagsAdapter

class NoteDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteDetailBinding

    private lateinit var tagsAdapter: TagsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val noteId: String = intent.getStringExtra(KEY_NOTE) ?: ""
        val note = Filters.filterNoteById(noteListExample, noteId)
        if (note != null) {
            initUI(note)
        }
        initListeners()
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(note: Note) {
        binding.tvNoteTittle.text = note.title
        binding.tvNoteBody.text = note.body
        if (note.cover != null) {
            binding.ivFrontNote.visibility = View.VISIBLE
            if (note.cover.srcImage && note.cover.src != null) {
                binding.ivFrontNote.setImageResource(note.cover.src!!)
            } else if (note.cover.uri != null) {
                binding.ivFrontNote.setImageURI(note.cover.uri)
            }
        }
        binding.root.setBackgroundColor(ContextCompat.getColor(this, note.background))

        tagsAdapter = TagsAdapter(note.tags)
        binding.rvSelectedTags.apply {
            layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tagsAdapter
        }
    }


}