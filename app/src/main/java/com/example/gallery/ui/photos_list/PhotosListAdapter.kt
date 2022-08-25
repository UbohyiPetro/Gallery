package com.example.gallery.ui.photos_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.ui.model.PhotoItem
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotosListAdapter : ListAdapter<PhotoItem, PhotosListAdapter.PhotosViewHolder>(
    object : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.photoUrl == newItem.photoUrl
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem == newItem
        }

    }
) {
    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.photo_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = currentList[position]
        holder.itemView.apply {
            setOnClickListener {
                findNavController().navigate(
                    PhotosListFragmentDirections.actionPhotosListFragmentToPhotoFragment(
                        photo.photoUrl
                    )
                )
            }
            Glide.with(this).load(photo.photoUrl)
                .fitCenter()
                .into(ivPhoto)
            tvUsername.text = photo.username
        }
    }


}
