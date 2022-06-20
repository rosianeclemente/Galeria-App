package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityItemBinding
import com.example.myapplication.model.ClosetGram

class ClosetAdapter(private val onClickListener: (closet: ClosetGram) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<ClosetGram, ClosetAdapter.ClosetItemViewHolder>(
        DIFF_CALLBACK()
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ClosetAdapter.ClosetItemViewHolder {
        val binding =
            ActivityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClosetItemViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(
        holder: ClosetAdapter.ClosetItemViewHolder,
        position: Int,
    ) {
        holder.bind(getItem(position))
    }

    inner class ClosetItemViewHolder(
        private val binding: ActivityItemBinding,
        private val onClickListener: (ClosetGram) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(closet: ClosetGram) {
            Glide.with(binding.root.context)
                .load(closet.image)
                .centerCrop()
                .into(binding.imageItem)
            binding.titleItem.text = closet.title
            binding.root.setOnClickListener {
                onClickListener.invoke(closet)
            }
        }
    }
}

class DIFF_CALLBACK : DiffUtil.ItemCallback<ClosetGram>() {
    override fun areItemsTheSame(oldItem: ClosetGram, newItem: ClosetGram): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ClosetGram, newItem: ClosetGram): Boolean {
        return oldItem.id == newItem.id
    }
}
