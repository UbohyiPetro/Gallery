package com.example.gallery.ui.photos_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gallery.R
import com.example.gallery.ui.model.PhotoItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.photos_list_fragment.*

@AndroidEntryPoint
class PhotosListFragment : Fragment(R.layout.photos_list_fragment) {

    private val photos = listOf(
        PhotoItem("fdgdf3"),
        PhotoItem("3523"),
        PhotoItem("gdfs"),
        PhotoItem("fdgdf3"),
        PhotoItem("fdgdf3"),
        PhotoItem("gdsjri"),
        PhotoItem("fdgdf3"),
        PhotoItem("fdgdf3"),
        PhotoItem("fdgdf3"),
        PhotoItem("352"),
        PhotoItem("vsjafa"),
        PhotoItem("fdgdf3"),
        PhotoItem("fdgdf3"),
        PhotoItem("fdgdf3"),
        PhotoItem("4382u5"),
        PhotoItem("fdgdf3"),
    )

    private val photosListAdapter: PhotosListAdapter = PhotosListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        photosListAdapter.submitList(photos)
    }

    private fun setupRecyclerView() {
        rvPhotos.apply {
            adapter = photosListAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }
}