package com.infobooktechnologies.worldoflumia.ui

import android.R.attr.button
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.infobooktechnologies.worldoflumia.databinding.ActivityHomeScreenBinding
import com.infobooktechnologies.worldoflumia.ui.listener.ToolbarListener


class HomeScreenActivity: WOLumiaBaseActivity<ActivityHomeScreenBinding,HomeViewModel>(),View.OnClickListener {

    override fun getViewBinding() = ActivityHomeScreenBinding.inflate(layoutInflater)

    override fun getViewModel() = HomeViewModel::class.java


    override fun setUpUi() {
        setVisibilityFalseToolBar()
        visibilityHeaderTitleAndLog()
        binding.player1.button.text = "1 Player"
        binding.player1.button.tag = 0
        binding.player1.button.setOnClickListener(this)
        binding.player2.button.text = "2 Player"
        binding.player2.button.tag = 1
        binding.player2.button.setOnClickListener(this)
        binding.player3.button.text = "3 Player"
        binding.player3.button.tag = 2
        binding.player3.button.setOnClickListener(this)
        binding.player4.button.text = "4 Player"
        binding.player4.button.tag = 3
        binding.player4.button.setOnClickListener(this)

//       resources.getStringArray(R.array.player_list).forEachIndexed { tag, btnName ->
//            val buttonLayout = RowLayoutButtonYellowBinding.inflate(layoutInflater)
//            buttonLayout.button.text = btnName
//            buttonLayout.button.tag = tag
//
//
//            val params = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//            params.setMargins(20, 20, 20, 20)
//            buttonLayout.button.layoutParams = params
//            buttonLayout.button.setOnClickListener(this)
//            binding.buttonListLayout.addView(buttonLayout.root)
//            /*val v: View = vi.inflate(R.layout.row_layout_homescreen, null)
//            val button = v.findViewById(R.id.button) as Button
//            button.tag = tag
//            button.text = btnName
//            binding.buttonListLayout.addView(button)*/
//        }



    }

    override fun onClick(view: View?) {
        var intent =Intent(this,PlayerActivity::class.java)
        when(view!!.tag){
            0->intent.putExtra("position",0)
            1->intent.putExtra("position",1)
            2->intent.putExtra("position",2)
            3->intent.putExtra("position",3)
        }
        startActivity(intent)
    }




}