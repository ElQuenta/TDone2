package ubp.com.tdone.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ubp.com.tdone.R
import ubp.com.tdone.controller.mediators.ColorActivityMediator
import ubp.com.tdone.databinding.ActivityCreateTagsBinding

class CreateTagsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateTagsBinding

    private val mediator = ColorActivityMediator
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
            onBackPressed()
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