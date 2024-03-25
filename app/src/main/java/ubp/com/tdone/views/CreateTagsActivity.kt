package ubp.com.tdone.views

import User
import java.util.UUID;
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ubp.com.tdone.R
import ubp.com.tdone.controller.mediators.ColorActivityMediator
import ubp.com.tdone.controller.mediators.TagActivityMediator
import ubp.com.tdone.databinding.ActivityCreateTagsBinding
import ubp.com.tdone.model.DBConection
import ubp.com.tdone.model.dataclases.Tag

class CreateTagsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateTagsBinding

    private val mediator = ColorActivityMediator
    private val mediatorTag = TagActivityMediator
    private var currentColor = R.color.white
    private val colorList = listOf(
        R.color.color_tag_1,
        R.color.color_tag_2,
        R.color.color_tag_3,
        R.color.color_tag_4,
        R.color.color_tag_5,
        R.color.color_tag_6,
        R.color.color_tag_7,
        R.color.color_tag_8,
        R.color.color_tag_9,
        R.color.color_tag_10,
        R.color.color_tag_11,
        R.color.color_tag_12,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreateTagsBinding.inflate(layoutInflater)
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
            this.finish()
        }
        binding.bntCrearItem.setOnClickListener {
            val name = binding.etTaskTitle.text.toString()
            if (name.isNotEmpty()){
                val newTag = Tag(
                    id = UUID.randomUUID().toString(),
                    userId = User.getCurrentUser()!!.uid,
                    name = name,
                    color = currentColor
                )
                CoroutineScope(Dispatchers.IO).launch {
                    DBConection.createTag(newTag)
                }.invokeOnCompletion {
                    mediatorTag.notifyTagListUpdated()
                    this.finish()
                }
            }
        }
    }

    private fun initUI() {
        mediator.setActivity(this,false)
        mediator.initColorList(colorList)
    }

    fun updateColor(color:Int){
        currentColor = color
    }


}