package ubp.com.tdone.views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private val mainHandler = Handler(Looper.getMainLooper())

    private var showingFabs = false

    companion object {
        const val KEY_TASK = "key_task"
        const val KEY_NOTE = "key_note"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.drawerLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
        initListeners()
    }

    @SuppressLint("RestrictedApi")
    override fun onBackPressed() {
        val currentDestination = navController.currentDestination
        val homeDestination = navController.findDestination(R.id.homeFragment)
        if (currentDestination != null && currentDestination == homeDestination) {
            finishAffinity()
        } else {
            hideFabs()
            super.onBackPressed()
        }
    }


    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.fabAdd.setOnClickListener {
            if (!showingFabs) {
                showFabs()
            } else {
                hideFabs()
            }
            showingFabs = !showingFabs
        }
        binding.fabAddNote.setOnClickListener {
            Toast.makeText(this, "nueva nota", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CreateNoteActivity::class.java)
            hideFabs()
            startActivity(intent)
        }
        binding.fabAddTask.setOnClickListener {
            Toast.makeText(this, "nueva tarea", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CreateTaskActivity::class.java)
            hideFabs()
            startActivity(intent)
        }
        binding.containerLayout.setOnClickListener { hideFabs() }
        binding.navView.getHeaderView(0).findViewById<ImageButton>(R.id.btn_nav_configurations)
            .setOnClickListener {

            }
    }

    private fun initUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()


        // Habilita la navegación mediante el NavController en el menú hamburguesa
        binding.navView.setupWithNavController(navController)

    }

    /*
    animaciones
     */
    private fun showFabs() {
        binding.fabAdd.animate().rotationBy(45f)
        animateFabVisibility(binding.fabAddNote, true)
        animateFabVisibility(binding.fabAddTask, true)
        mainHandler.postDelayed(
            {
                binding.containerLayout.visibility = View.VISIBLE
            }, 200
        )

    }

    private fun hideFabs() {
        binding.fabAdd.animate().rotation(0f)
        animateFabVisibility(binding.fabAddNote, false)
        animateFabVisibility(binding.fabAddTask, false)
        mainHandler.postDelayed(
            {
                binding.containerLayout.visibility = View.GONE
            }, 200
        )

    }

    fun animateFabVisibility(fab: FloatingActionButton, visible: Boolean) {
        val animator = ValueAnimator.ofFloat(if (visible) 0f else 1f, if (visible) 1f else 0f)
        animator.duration = 200L // Set the duration of the animation
        animator.interpolator = AccelerateDecelerateInterpolator() // Set the interpolator

        animator.addUpdateListener { animation ->
            fab.alpha = animation.animatedValue as Float
        }

        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                fab.visibility = if (visible) View.VISIBLE else View.GONE
            }
        })

        animator.start()
    }
}