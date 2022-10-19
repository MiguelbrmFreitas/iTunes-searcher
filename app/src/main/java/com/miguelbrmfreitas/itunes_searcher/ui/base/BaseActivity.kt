package com.miguelbrmfreitas.itunes_searcher.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity()
{
    @LayoutRes
    abstract fun layoutId(): Int

    abstract val viewModel: V

    lateinit var binding: ViewDataBinding

    abstract fun bindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupDataBinding()
    }

    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())
        binding.setLifecycleOwner { this.lifecycle }
        binding.setVariable(bindingVariable(), this.viewModel)
        binding.executePendingBindings()
    }

    fun hideKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}