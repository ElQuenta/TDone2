package ubp.com.tdone.views.fragments.creationItemFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ubp.com.tdone.controller.mediators.DateActivityMediator
import ubp.com.tdone.databinding.FragmentSelectDateBinding
import java.util.Date
import java.util.GregorianCalendar

class SelectDateFragment : Fragment() {

    private lateinit var binding: FragmentSelectDateBinding
    private val mediator = DateActivityMediator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectDateBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initListeners()
    }

    private fun initUI(){
        binding.calendarviewSelectionDate.setDate(mediator.date.time)
    }

    private fun initListeners() {
        binding.calendarviewSelectionDate.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = Date(year - 1900, month, dayOfMonth)
            mediator.initDate(selectedDate)
        }
    }
}