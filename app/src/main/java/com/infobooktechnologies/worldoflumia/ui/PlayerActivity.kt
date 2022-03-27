package com.infobooktechnologies.worldoflumia.ui

import android.os.Bundle
import android.view.WindowManager
import com.infobooktechnologies.worldoflumia.databinding.ActivityPlayerLayoutBinding
import com.infobooktechnologies.worldoflumia.ui.listener.ToolbarListener

class PlayerActivity : WOLumiaBaseActivity<ActivityPlayerLayoutBinding,PlayerViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    override fun getViewBinding() = ActivityPlayerLayoutBinding.inflate(layoutInflater)

    override fun getViewModel() = PlayerViewModel::class.java

    override fun setUpUi() {
        setVisibilityTrueToolBar()
        var position= intent.getIntExtra("position",0)
        val fragment = PlayerFragment.newInstance(position)
        supportFragmentManager.beginTransaction().replace(binding.frameLayout.id,fragment,"").commit()

    }

}