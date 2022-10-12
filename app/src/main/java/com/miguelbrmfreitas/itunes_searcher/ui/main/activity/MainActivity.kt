package com.miguelbrmfreitas.itunes_searcher.ui.main.activity

import android.os.Bundle
import com.miguelbrmfreitas.itunes_searcher.BR
import com.miguelbrmfreitas.itunes_searcher.R
import com.miguelbrmfreitas.itunes_searcher.ui.base.BaseActivity
import com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override val viewModel: MainViewModel by viewModel(owner = this)

    override fun layoutId() = R.layout.activity_main

    override fun bindingVariable() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.startView()
    }
}