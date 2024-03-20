package ubp.com.tdone.ui

import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private val mainHandler = Handler(Looper.getMainLooper())

    private var showingFabs = false

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

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            hideFabs()
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
        }
        binding.fabAddTask.setOnClickListener {
            Toast.makeText(this, "nueva tarea", Toast.LENGTH_SHORT).show()

        }
        binding.containerLayout.setOnClickListener { hideFabs() }
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
        mainHandler.postDelayed(
            {
                binding.fabAddNote.visibility = View.VISIBLE
                binding.fabAddTask.visibility = View.VISIBLE
                binding.containerLayout.visibility = View.VISIBLE
            },
            200
        )

    }

    private fun hideFabs() {
        binding.fabAdd.animate().rotation(0f)
        mainHandler.postDelayed(
            {
                binding.fabAddTask.visibility = View.GONE
                binding.fabAddNote.visibility = View.GONE
                binding.containerLayout.visibility = View.GONE
            },
            200
        )

    }
}