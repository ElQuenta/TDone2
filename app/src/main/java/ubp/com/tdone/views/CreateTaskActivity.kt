package ubp.com.tdone.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.R
import ubp.com.tdone.controller.mediators.DateActivityMediator
import ubp.com.tdone.controller.mediators.TagActivityMediator
import ubp.com.tdone.databinding.ActivityCreateTaskBinding
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.views.recyclerViews.showingElements.TagsAdapter
import java.util.Date

class CreateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateTaskBinding

    private lateinit var navController: NavController
    private lateinit var tagsAdapter: TagsAdapter

    private var showingFragments = false
    private var currentTags: MutableList<Tag> = mutableListOf()
    private val mediatorTag = TagActivityMediator
    private val mediatorDate = DateActivityMediator
    private var date: Date = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTaskBinding.inflate(layoutInflater)
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

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if (showingFragments) {
            binding.navHostFragment.visibility = View.GONE
            showingFragments = false
        } else {
            mediatorTag.tagList = mutableListOf()
            mediatorDate.date = Date()
            this.finish()
        }
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            mediatorTag.tagList = mutableListOf()
            mediatorDate.date = Date()
            this.finish()
        }
        binding.efabAddTag.setOnClickListener {
            changeCurrentFragment(R.id.selectTagsFragment2)
        }
        binding.efabAddDate.setOnClickListener {
            changeCurrentFragment(R.id.selectDateFragment2)
        }
    }

    private fun initUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        tagsAdapter = TagsAdapter(currentTags)
        binding.rvSelectedTags.apply {
            layoutManager = LinearLayoutManager(
                binding.root.context,
                LinearLayoutManager.HORIZONTAL, false
            )
            adapter = tagsAdapter
        }
        mediatorTag.setActivity(this, false)
        mediatorDate.setActivity(this)
    }

    fun updateTagList(tagList: MutableList<Tag>) {
        currentTags = tagList
        tagsAdapter.updateTagList(currentTags)
        tagsAdapter.notifyDataSetChanged()
    }

    private fun isOnTheSameFragment(fragmentID: Int): Boolean {
        val currentDestination = navController.currentDestination
        val fragmentDestination = navController.graph.findNode(fragmentID)
        return currentDestination != null && currentDestination.id == fragmentDestination?.id
    }

    private fun changeCurrentFragment(fragmentID: Int) {
        if (!showingFragments && isOnTheSameFragment(fragmentID)) {
            showingFragments = true
            binding.navHostFragment.visibility = View.VISIBLE
        } else if (showingFragments && isOnTheSameFragment(fragmentID)) {
            showingFragments = false
            binding.navHostFragment.visibility = View.GONE
        } else {
            showingFragments = true
            navController.navigate(fragmentID)
            binding.navHostFragment.visibility = View.VISIBLE
        }
    }

    fun updateDate(date:Date){
        this.date = date
    }

    fun closeOption(){
        binding.navHostFragment.visibility = View.GONE
        showingFragments = false
    }

}