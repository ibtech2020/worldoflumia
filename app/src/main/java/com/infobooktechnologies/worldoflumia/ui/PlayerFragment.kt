package com.infobooktechnologies.worldoflumia.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.infobooktechnologies.worldoflumia.databinding.FragmentThreePlayerBinding
import com.infobooktechnologies.worldoflumia.ui.adapter.PlayerThreeAdapter
import com.infobooktechnologies.worldoflumia.ui.common.Constant.FRAGMENT_POSITION
import com.infobooktechnologies.worldoflumia.ui.common.Constant.PLAYERFOUR
import com.infobooktechnologies.worldoflumia.ui.common.Constant.PLAYERONE
import com.infobooktechnologies.worldoflumia.ui.common.Constant.PLAYERTHREE
import com.infobooktechnologies.worldoflumia.ui.common.Constant.PLAYERTWO
import com.infobooktechnologies.worldoflumia.ui.listener.ToolbarListener

class PlayerFragment : WOLumiaBaseFragment<FragmentThreePlayerBinding,PlayerViewModel>(),ToolbarListener {
    var listcount=1
    var viewType=PLAYERONE
    companion object {
        @JvmStatic
        fun newInstance(position: Int) = PlayerFragment().apply {
            arguments = Bundle().apply {
                putInt(FRAGMENT_POSITION,position)
            }
        }
    }

    lateinit var playerThreeAdapter: PlayerThreeAdapter
    override fun getViewModelClass() = PlayerViewModel::class.java

    override fun getViewBinding() = FragmentThreePlayerBinding.inflate(layoutInflater)

    override fun setUpViews() {
        super.setUpViews()
        (activity as PlayerActivity).setCustomObjectListener(this)


        arguments?.getInt(FRAGMENT_POSITION).let {
            when(it){
                0->{
                    viewType = PLAYERONE
                    listcount = 1
                }
                1->{
                    viewType = PLAYERTWO
                    listcount = 2
                }
                2->{
                    viewType = PLAYERTHREE
                    listcount = 3
                }
                3->{
                    viewType = PLAYERFOUR
                    listcount = 4
                }
            }
        }

        playerThreeAdapter = PlayerThreeAdapter(viewType)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter= playerThreeAdapter
        playerThreeAdapter.listCount(listcount)
    }

    override fun onHomeButtonClick() {
        (activity as PlayerActivity).finish()
    }

    override fun onRestButtonClick() {
        playerThreeAdapter = PlayerThreeAdapter(viewType)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter= playerThreeAdapter
        playerThreeAdapter.listCount(listcount)
    }
}