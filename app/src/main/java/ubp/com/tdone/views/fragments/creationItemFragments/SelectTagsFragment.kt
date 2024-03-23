package ubp.com.tdone.views.fragments.creationItemFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ubp.com.tdone.R
import ubp.com.tdone.databinding.FragmentSelectTagsBinding
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.model.tagListExample
import ubp.com.tdone.views.recyclerViews.creatingElements.TagSelectorAdapter

class SelectTagsFragment : Fragment() {

    private lateinit var binding: FragmentSelectTagsBinding

    private lateinit var tagSelectorAdapter: TagSelectorAdapter

    private var tagList: MutableList<Tag> =
        mutableListOf(Tag(id = NEW_TAG_ID, name = "Crear Tag", color = R.color.black))
    private val currentTags: MutableList<Tag> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectTagsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initUI() {
        tagList = (tagListExample + tagList).toMutableList()
        tagSelectorAdapter = TagSelectorAdapter(
            tagList,
            { createNewTag() },
            { tag, checked -> updateCurrentTags(tag, checked) })
        binding.rvSelectTags.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = tagSelectorAdapter
        }
    }

    private fun updateCurrentTags(tag: Tag, checked: Boolean) {
        if (checked) {
            currentTags.add(tag)
        } else {
            currentTags.remove(tag)
        }
    }

    private fun createNewTag() {

    }

    companion object {
        const val NEW_TAG_ID = "newTag"
    }


}