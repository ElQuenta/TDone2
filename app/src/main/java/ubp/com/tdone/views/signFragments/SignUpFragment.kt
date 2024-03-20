package ubp.com.tdone.views.signFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ubp.com.tdone.R
import ubp.com.tdone.databinding.FragmentSignUpBinding
import ubp.com.tdone.views.MainActivity

class SingUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
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
        binding.btnSingUp.setOnClickListener{
            navToHome()
        }
    }

    private fun navToHome(){
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }

}