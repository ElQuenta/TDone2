package ubp.com.tdone.ui

import android.os.Bundle
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
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

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
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.log_out -> {
                    // Handle log out action
                    Toast.makeText(this, "cerrando sesion", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    val language: String? = when (menuItem.itemId) {
                        R.id.language_es -> {
                            // Handle Spanish language
                            "español"
                        }
                        R.id.language_en -> {
                            // Handle English language
                            "en"
                        }
                        else -> {
                            null
                        }
                    }
                    if (language != null) {
                        Toast.makeText(this, "el lengauje es $language", Toast.LENGTH_SHORT).show()
                    }
                    // Close the navigation drawer
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
            }
        }
    }

    private fun initUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()


        // Habilita la navegación mediante el NavController en el menú hamburguesa
        binding.navView.setupWithNavController(navController)

    }
}