package com.example.gallery.ui.photo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.gallery.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.photo_fragment.*

@AndroidEntryPoint
class PhotoFragment : Fragment(R.layout.photo_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl = arguments?.getString("imageUrl")
        Glide.with(this).load(imageUrl)
            .centerCrop()
            .into(ivFullPhoto)
    }
}