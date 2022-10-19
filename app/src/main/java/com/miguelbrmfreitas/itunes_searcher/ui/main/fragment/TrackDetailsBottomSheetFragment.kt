package com.miguelbrmfreitas.itunes_searcher.ui.main.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.itunes_searcher.R
import com.miguelbrmfreitas.itunes_searcher.databinding.BottomSheetTrackDetailsBinding
import com.miguelbrmfreitas.itunes_searcher.ui.util.extensions.createCircularProgressDrawable

class TrackDetailsBottomSheetFragment(private val searchResult: SearchResult) : BottomSheetDialogFragment()
{
    private lateinit var bottomSheetDialog: BottomSheetDialog

    private lateinit var bottomSheetBinding: BottomSheetTrackDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bottomSheetBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_track_details,
            container,
            true
        )

        bottomSheetBinding.setLifecycleOwner { this.lifecycle }

        return bottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        setupView()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        return bottomSheetDialog
    }

    private fun setupView() {
        val context = bottomSheetBinding.root.context
        val circularProgressDrawable = context.createCircularProgressDrawable()

        bottomSheetBinding.ivCover.load(searchResult.imageCoverUrl) {
            placeholder(circularProgressDrawable)
            error(R.drawable.ic_song_placeholder)
        }

        bottomSheetBinding.searchResult = searchResult
    }
}