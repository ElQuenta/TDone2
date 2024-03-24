package ubp.com.tdone.views

import User
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ubp.com.tdone.R
import ubp.com.tdone.databinding.ActivityUserSettingsBinding

class UserSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserSettingsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUi()
        initListener()
    }

    private fun initUi() {
        binding.tvUserEmail.text = User.getCurrentUser()?.email ?: "Correo del Usuario"
        binding.tvUserName.text = User.getCurrentUser()?.displayName ?: "Nombre de Usuario"
    }

    private fun initListener() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.btnLogOut.setOnClickListener {
            User.signOut()
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }
    }
}