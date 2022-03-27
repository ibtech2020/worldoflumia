package com.infobooktechnologies.worldoflumia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class WOLumiaBaseFragment<V : ViewBinding, T : ViewModel> : Fragment() {

    open var useSharedViewModel: Boolean = false

    protected lateinit var viewModel: T
    protected abstract fun getViewModelClass(): Class<T>

    protected lateinit var binding: V
    protected abstract fun getViewBinding(): V



//    private val disposableContainer = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeData()
    }

    open fun setUpViews() {}

    open fun observeView() {}

    open fun observeData() {}

    private fun init() {
        binding = getViewBinding()
        viewModel = if (useSharedViewModel) {
            ViewModelProvider(requireActivity()).get(
                getViewModelClass()
            )
        } else {
            ViewModelProvider(this).get(getViewModelClass())
        }
    }

//    fun Disposable.addToContainer() = disposableContainer.add(this)

    override fun onDestroyView() {
//        disposableContainer.clear()
        super.onDestroyView()
    }
}