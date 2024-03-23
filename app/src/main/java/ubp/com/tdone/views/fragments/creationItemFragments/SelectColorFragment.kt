package ubp.com.tdone.views.fragments.creationItemFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ubp.com.tdone.R
import ubp.com.tdone.controller.mediators.CreateNotesMediator
import ubp.com.tdone.databinding.FragmentSelectColorBinding
import ubp.com.tdone.views.recyclerViews.creatingElements.ColorAdapter

class SelectColorFragment : Fragment() {

    private lateinit var binding: FragmentSelectColorBinding

    private lateinit var colorAdapter: ColorAdapter
    private val mediator = CreateNotesMediator

    private var colorList: List<Int> = listOf()
    private var currentColor = R.color.white

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectColorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        colorList = mediator.colorSet

        colorAdapter = ColorAdapter(
            colorList,
            comparateColor = { comparateToCurrentColor(it) },
            changeCurrentColor = { changeCurrentColor(it) })
        binding.rvSelectColors.apply {
            layoutManager =
                GridLayoutManager(binding.root.context, 4, GridLayoutManager.VERTICAL, false)
            adapter = colorAdapter
        }
    }

    private fun comparateToCurrentColor(color: Int) = currentColor == color

    private fun changeCurrentColor(color: Int) {
        currentColor = color
        colorAdapter.notifyDataSetChanged()
        mediator.setCurrentColor(color)
    }

}