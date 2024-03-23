package ubp.com.tdone.views.fragments.signFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ubp.com.tdone.R
import ubp.com.tdone.databinding.FragmentInitialBinding

class InitialFragment : Fragment() {

    private lateinit var binding: FragmentInitialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInitialBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnNavSingUp.setOnClickListener {
            findNavController().navigate(R.id.action_initialFragment_to_singUpFragment)
        }
        binding.btnNavSingIn.setOnClickListener {
            findNavController().navigate(R.id.action_initialFragment_to_signInFragment)
        }
    }
}