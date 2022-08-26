package com.example.gallery.ui.photos_list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gallery.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.photos_list_fragment.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhotosListFragment : Fragment(R.layout.photos_list_fragment) {

    private val photosListAdapter: PhotosListAdapter = PhotosListAdapter()
    private val photosListViewModel: PhotosListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        lifecycleScope.launch {
            photosListViewModel.photosViewState.collect { viewState ->
                when {
                    viewState.isLoading -> showLoading()
                    !viewState.isLoading -> {
                        hideLoading()
                        photosListAdapter.submitData(viewState.photos)
                    }
                }
            }
        }
    }

    private fun showLoading() {
        rvPhotos.isVisible = false
        pbLoader.isVisible = true
        tvError.isVisible = false
    }

    private fun hideLoading() {
        rvPhotos.isVisible = true
        pbLoader.isVisible = false
        tvError.isVisible = false
    }

    private fun showError(error: String) {
        rvPhotos.isVisible = false
        pbLoader.isVisible = false
        tvError.isVisible = true
        tvError.text = error
    }

    private fun setupRecyclerView() {
        rvPhotos.apply {
            adapter = photosListAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }
}