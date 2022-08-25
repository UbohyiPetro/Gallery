package com.example.gallery.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.ui.PhotosActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.photo_fragment.*

@AndroidEntryPoint
class PhotoFragment : Fragment(R.layout.photo_fragment) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val actionBar: ActionBar? = (activity as PhotosActivity?)?.supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val actionBar: ActionBar? = (activity as PhotosActivity?)?.supportActionBar
        actionBar?.setHomeButtonEnabled(false)
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val circularProgressDrawable = CircularProgressDrawable(requireContext())
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val imageUrl = arguments?.getString("imageUrl")
        Glide.with(this).load(imageUrl)
            .placeholder(circularProgressDrawable)
            .centerCrop()
            .into(ivFullPhoto)
    }
}