package ubp.com.tdone.views

import User
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
        verifyUser()
    }

    private fun verifyUser() {
        if (User.getCurrentUser() != null){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    @SuppressLint("RestrictedApi")
    override fun onBackPressed() {
        val currentDestination = navController.currentDestination
        val homeDestination = navController.findDestination(R.id.initialFragment)
        if (currentDestination != null && currentDestination == homeDestination) {
            finishAffinity()
        } else {
            super.onBackPressed()
        }
    }
}