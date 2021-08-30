package com.hadi.mvvmplayground.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.hadi.mvvmplayground.data.model.PicsResponse
import com.hadi.mvvmplayground.databinding.ItemPicsBinding

class PicsAdapter : RecyclerView.Adapter<PicsAdapter.PicsViewHolder>() {

    inner class PicsViewHolder(val binding: ItemPicsBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<PicsResponse.PicsResponseItem>() {
        override fun areItemsTheSame(
            oldItem: PicsResponse.PicsResponseItem,
            newItem: PicsResponse.PicsResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PicsResponse.PicsResponseItem,
            newItem: PicsResponse.PicsResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PicsViewHolder(
        ItemPicsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: PicsViewHolder, position: Int) {

        val circularProgressDrawable = CircularProgressDrawable(holder.binding.root.context).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }



        val picItem = differ.currentList[position]
        holder.binding.apply {
            ivImage.load(picItem.downloadUrl) {
                crossfade(true)
                placeholder(circularProgressDrawable)
            }
            tvImageId.text = picItem.id
            tvImageSize.text = "${picItem.width} x ${picItem.height}"
            tvImageAuthor.text = picItem.author
        }
    }
}