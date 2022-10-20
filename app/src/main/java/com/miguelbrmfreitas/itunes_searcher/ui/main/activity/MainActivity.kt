package com.miguelbrmfreitas.itunes_searcher.ui.main.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.viewModelScope
import com.miguelbrmfreitas.itunes_searcher.BR
import com.miguelbrmfreitas.itunes_searcher.R
import com.miguelbrmfreitas.itunes_searcher.ui.base.BaseActivity
import com.miguelbrmfreitas.itunes_searcher.ui.main.fragment.TrackDetailsBottomSheetFragment
import com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    companion object {
        const val MAIN_TAG = "MAIN_ACTIVITY"
    }

    override val viewModel: MainViewModel by viewModel(owner = this)

    override fun layoutId() = R.layout.activity_main

    override fun bindingVariable() = BR.viewModel

    private lateinit var bottomSheetFragment: TrackDetailsBottomSheetFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.startView()
        observeFields()
    }

    // Method binded to onClick attribute on ib_search at activity_main.xml
    fun onSearchClicked(view: View) {
        viewModel.onSearchClicked()
        hideKeyBoard()
    }

    private fun observeFields() {
        viewModel.apply {
            viewModelScope.launch {
                mainViewModelState
                    .hasToShowBottomSheet
                    .collectLatest {
                        if (it) {
                            showBottomSheetDialog()
                        }
                    }
            }
        }
    }

    private fun showBottomSheetDialog() {
        val searchResult = viewModel.selectedResult
        if (searchResult != null) {
            bottomSheetFragment = TrackDetailsBottomSheetFragment(searchResult)
            bottomSheetFragment.show(supportFragmentManager, MAIN_TAG)
            viewModel.mainViewModelState.hasToShowBottomSheet.value = false
        }
    }
}