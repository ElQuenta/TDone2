package ubp.com.tdone.views.fragments.creationItemFragments

import User
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ubp.com.tdone.R
import ubp.com.tdone.controller.mediators.CoverNotesMediator
import ubp.com.tdone.databinding.FragmentSelectCoverBinding
import ubp.com.tdone.model.dataclases.Cover
import ubp.com.tdone.views.recyclerViews.creatingElements.CoverAdapter

class SelectCoverFragment : Fragment() {

    private lateinit var binding: FragmentSelectCoverBinding

    private lateinit var coverAdapter: CoverAdapter
    private val mediator = CoverNotesMediator

    private val coverList: List<Cover>
        get() = listOf(
            Cover(id = "", userId = User.getCurrentUser()?.uid ?: "noUser", src = R.drawable.background_no_image),
            Cover(id = "", userId = User.getCurrentUser()?.uid ?: "noUser",src = R.drawable.background1),
            Cover(id = "", userId = User.getCurrentUser()?.uid ?: "noUser",src = R.drawable.background2),
            Cover(id = "", userId = User.getCurrentUser()?.uid ?: "noUser",src = R.drawable.background3),
            Cover(id = "", userId = User.getCurrentUser()?.uid ?: "noUser",src = R.drawable.background4),
            Cover(id = "", userId = User.getCurrentUser()?.uid ?: "noUser",src = R.drawable.background_galery),
        )
    private var currentCover = coverList.first()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectCoverBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        coverAdapter = CoverAdapter(coverList, {
            compareCovers(it)
        }, {
            changeCurrentCover(it)
        })
        binding.rvSelectCover.apply {
            layoutManager =
                GridLayoutManager(binding.root.context, 2, GridLayoutManager.HORIZONTAL, false)
            adapter = coverAdapter
        }
    }

    private fun compareCovers(cover: Cover) = currentCover == cover

    private fun changeCurrentCover(cover: Cover) {
        coverAdapter.notifyItemChanged(coverList.indexOf(currentCover))
        currentCover = cover
        coverAdapter.notifyItemChanged(coverList.indexOf(cover))
        if (cover != coverList.first()) {
            mediator.setCurrentCover(cover)
        }else{
            mediator.setCurrentCover(null)
        }
    }

}