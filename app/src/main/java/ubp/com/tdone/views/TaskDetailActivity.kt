package ubp.com.tdone.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.R
import ubp.com.tdone.controller.Filters
import ubp.com.tdone.databinding.ActivityTaskDetailBinding
import ubp.com.tdone.model.dataclases.Task
import ubp.com.tdone.model.taskListExample
import ubp.com.tdone.views.MainActivity.Companion.KEY_TASK
import ubp.com.tdone.views.recyclerViews.showingElements.TagsAdapter

class TaskDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskDetailBinding

    private lateinit var tagsAdapter: TagsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val taskId = intent.getStringExtra(KEY_TASK) ?: ""
        val task = Filters.filterTaskById(taskListExample,taskId)
        if (task!=null) {
            initUI(task)
        }
        initListeners()
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(task: Task) {
        tagsAdapter = TagsAdapter(task.tag)
        binding.rvSelectedTags.apply {
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tagsAdapter
        }

        binding.tvTaskTittle.text = task.title
        binding.tvTaskBody.text = task.description
    }
}