package ubp.com.tdone.views.fragments.signFragments

import User
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ubp.com.tdone.R
import ubp.com.tdone.databinding.FragmentSignInBinding
import ubp.com.tdone.views.MainActivity


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_singUpFragment)
        }
        binding.btnSingIn.setOnClickListener{
            login()
        }
    }

    private fun login() {
        val email = binding.emailEt.text.toString()
        val pass = binding.passET.text.toString()
        if (verifyFields(email, pass)){
            User.signInWithEmailAndPassword(email,pass,binding.root.context){
                navToHome()
            }
        }else{
            Toast.makeText(binding.root.context, "No deje espacios en Blanco", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyFields(email:String,pass:String):Boolean = email.isNotEmpty()&&pass.isNotEmpty()

    private fun navToHome(){
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }
}