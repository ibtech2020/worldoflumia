package com.infobooktechnologies.worldoflumia.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.infobooktechnologies.worldoflumia.R
import com.infobooktechnologies.worldoflumia.databinding.ToolbarBinding
import com.infobooktechnologies.worldoflumia.ui.listener.ToolbarListener

abstract class WOLumiaBaseActivity<T: ViewBinding,M:ViewModel> : AppCompatActivity(), View.OnClickListener {
    lateinit var viewModel: M
    lateinit var binding: T
    private lateinit var toolbarBinding: ToolbarBinding

    private lateinit var toolbarListener: ToolbarListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbarBinding = ToolbarBinding.inflate(layoutInflater)
        setContentView(toolbarBinding.root)
        binding = getViewBinding()
        viewModel = ViewModelProvider(this,defaultViewModelProviderFactory).get(getViewModel())
        toolbarBinding.activityLayoutContainer.addView(binding.root)
//        toolbarListener =ToolbarListener



    }

    override fun onResume() {
        super.onResume()
        setSupportActionBar(toolbarBinding.myAwesomeToolbar)
//        toolbarBinding.btnReset.setBackgroundResource(R.drawable.ic_reset_counter_b)
        toolbarBinding.btnHome.setOnClickListener(this)
        toolbarBinding.btnReset.setOnClickListener(this)
        setUpUi()
    }

    abstract fun getViewBinding():T

    abstract fun getViewModel():Class<M>
    abstract fun setUpUi()

    fun setVisibilityTrueToolBar(){
        toolbarBinding.myAwesomeToolbar.visibility = View.VISIBLE
    }
    fun setVisibilityFalseToolBar(){
        toolbarBinding.myAwesomeToolbar.visibility = View.GONE
    }

    fun visibilityHeaderTitleAndLog(){
        toolbarBinding.appImageIcon.visibility = View.VISIBLE
        toolbarBinding.appTitle.visibility = View.VISIBLE
    }

    open fun setCustomObjectListener(listener: ToolbarListener) {
        toolbarListener = listener
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_home-> {
                if (toolbarListener!=null){
                    toolbarListener.onHomeButtonClick()
                }
            }
            R.id.btn_reset-> {
                if (toolbarListener!=null){
                    toolbarListener.onRestButtonClick()
                }
            }
        }
    }
}

