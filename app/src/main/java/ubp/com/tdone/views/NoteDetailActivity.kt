package ubp.com.tdone.views

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import ubp.com.tdone.databinding.ActivityNoteDetailBinding
import ubp.com.tdone.model.DBConection
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
        initUI(noteId)
        initListeners()
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            this.finish()
        }
    }

    private fun initUI(noteId: String) = lifecycleScope.launch{
        val note = DBConection.getNote(noteId)
        binding.tvNoteTittle.text = note?.title
        binding.tvNoteBody.text = note?.body
        if (note!!.cover != null) {
            if (note.cover!!.srcImage && note.cover.src != null) {
                binding.ivFrontNote.visibility = View.VISIBLE
                binding.ivFrontNote.setImageResource(note.cover.src!!)
            } else if (note.cover.uri != null) {
                binding.ivFrontNote.visibility = View.VISIBLE
                binding.ivFrontNote.setImageURI(note.cover.uri)
            }
        }
        binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, note.background))

        tagsAdapter = TagsAdapter(note.tags)
        binding.rvSelectedTags.apply {
            layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tagsAdapter
        }
    }


}