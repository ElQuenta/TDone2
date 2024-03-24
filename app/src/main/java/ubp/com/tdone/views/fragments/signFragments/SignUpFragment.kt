package ubp.com.tdone.views.fragments.signFragments

import User
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ubp.com.tdone.R
import ubp.com.tdone.databinding.FragmentSignUpBinding
import ubp.com.tdone.views.MainActivity

class SingUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_singUpFragment_to_signInFragment)
        }
        binding.btnSingUp.setOnClickListener {
            createAccount()
        }
    }

    private fun navToHome() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }

    private fun createAccount() {
        val email = binding.emailEt.text.toString()
        val pass = binding.passET.text.toString()
        val confirmPass = binding.confirmPassEt.text.toString()
        val username = binding.userNameEt.text.toString()
        if (nonEmptyFilds(email, username, pass, confirmPass)) {
            if (verifyPassword(pass, confirmPass)) {
                User.createUserWithEmailAndPassword(email, pass, username, binding.root.context) {
                    navToHome()
                }
            } else {
                Toast.makeText(
                    binding.root.context,
                    "La contraseña y su confirmación no Coincide",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(binding.root.context, "No dejes campos en Blanco", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun verifyPassword(pass: String, confirmPass: String): Boolean =
        pass.equals(confirmPass)

    private fun nonEmptyFilds(
        email: String, username: String, pass: String, confirmPass: String
    ): Boolean =
        email.isNotEmpty() && username.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()

}