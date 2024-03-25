package ubp.com.tdone.views

import User
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Timestamp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ubp.com.tdone.R
import ubp.com.tdone.controller.mediators.ColorActivityMediator
import ubp.com.tdone.controller.mediators.CoverNotesMediator
import ubp.com.tdone.controller.mediators.TagActivityMediator
import ubp.com.tdone.databinding.ActivityCreateNoteBinding
import ubp.com.tdone.model.DBConection
import ubp.com.tdone.model.dataclases.Cover
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.views.recyclerViews.showingElements.TagsAdapter
import java.util.UUID;

class CreateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateNoteBinding

    private lateinit var navController: NavController
    private lateinit var tagsAdapter: TagsAdapter

    private val mediatorCover = CoverNotesMediator
    private val mediatorColor = ColorActivityMediator
    private val mediatorTag = TagActivityMediator

    private val colorList = listOf<Int>(
        R.color.note_background_1,
        R.color.note_background_2,
        R.color.note_background_3,
        R.color.note_background_4,
        R.color.note_background_5,
        R.color.note_background_6,
        R.color.note_background_7,
        R.color.note_background_8,
        R.color.note_background_9,
        R.color.note_background_10,
        R.color.note_background_11,
        R.color.note_background_12
    )

    private var noteBackground: Int = R.color.note_background_1
    private var currentTags: MutableList<Tag> = mutableListOf()
    private var currentCover: Cover? = null
    private var showingFragments = false
    private var fristTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
        initListeners()
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            mediatorTag.tagList= mutableListOf()
            this.finish()
        }
        binding.efabAddCover.setOnClickListener {
            changeCurrentFragment(R.id.selectCoverFragment)
        }
        binding.efabAddTag.setOnClickListener {
            changeCurrentFragment(R.id.selectTagsFragment)
        }
        binding.efabAddBackgroundColor.setOnClickListener {
            if (fristTime) {
                mediatorColor.initColorList(colorList)
                fristTime=false
            }
            changeCurrentFragment(R.id.selectColorFragment)
        }
        binding.bntCrearItem.setOnClickListener {
            val title = binding.etNoteTitle.text.toString()
            val body = binding.etNoteBody.text.toString()
            if (title.isNotEmpty()) {
                val newNote = Note(
                    id = UUID.randomUUID().toString(),
                    userId = User.getCurrentUser()!!.uid,
                    title = title,
                    body = body.ifEmpty { null },
                    tags = currentTags,
                    cover = currentCover,
                    background = noteBackground,
                    createdAt = Timestamp.now(),
                    updatedAt = Timestamp.now()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    DBConection.createNote(newNote)
                }.invokeOnCompletion {
                    this.finish()
                }
            }
        }


    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if (showingFragments){
            binding.navHostFragment.visibility = View.GONE
            showingFragments= false
        }else {
            mediatorTag.tagList= mutableListOf()
            this.finish()
        }
    }

    private fun initUI() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        tagsAdapter = TagsAdapter(currentTags)
        binding.rvSelectedTags.apply {
            layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = tagsAdapter
        }

        mediatorColor.setActivity(this,true)
        mediatorTag.setActivity(this,true)
        mediatorCover.setActivity(this)
        printCover()

    }

    private fun printCover() {
        if (currentCover != null) {
            binding.ivFrontNote.visibility = View.VISIBLE
            if (currentCover!!.srcImage && currentCover!!.src != null) {
                currentCover!!.src?.let { binding.ivFrontNote.setImageResource(it) }
            } else if (currentCover!!.uri != null) {
                currentCover!!.uri?.let { binding.ivFrontNote.setImageURI(it) }
            }
        } else {
            binding.ivFrontNote.visibility = View.GONE
        }
    }

    fun updateBackground(color: Int) {
        noteBackground = color
        binding.root.setBackgroundColor(ContextCompat.getColor(this, color))
    }

    fun updateTagList(tagList: MutableList<Tag>) {
        currentTags = tagList
        tagsAdapter.updateTagList(currentTags)
        tagsAdapter.notifyDataSetChanged()
    }

    fun updateCover(cover: Cover?) {
        currentCover = cover
        printCover()
    }

    private fun isOnTheSameFragment(fragmentID: Int): Boolean {
        val currentDestination = navController.currentDestination
        val fragmentDestination = navController.graph.findNode(fragmentID)
        return currentDestination != null && currentDestination.id == fragmentDestination?.id
    }

    private fun changeCurrentFragment(fragmentID: Int){
        if (!showingFragments && isOnTheSameFragment(fragmentID)) {
            showingFragments=true
            binding.navHostFragment.visibility = View.VISIBLE
        } else if (showingFragments && isOnTheSameFragment(fragmentID)) {
            showingFragments=false
            binding.navHostFragment.visibility = View.GONE
        } else {
            showingFragments=true
            navController.navigate(fragmentID)
            binding.navHostFragment.visibility = View.VISIBLE
        }
    }

    fun closeOption(){
        binding.navHostFragment.visibility = View.GONE
        showingFragments = false
        navController.navigate(R.id.selectCoverFragment)
    }


}