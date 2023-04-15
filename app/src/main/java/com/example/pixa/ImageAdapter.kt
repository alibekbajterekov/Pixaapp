package com.example.pixa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixa.databinding.ItemImageBinding

class ImageAdapter(): RecyclerView.Adapter<ImageAdapter.ImageHolder>() {
    private val list: ArrayList<ImageModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun add(data:ArrayList<ImageModel>){
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class ImageHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imageModel: ImageModel) {
            binding.imageview.load(imageModel.largeImageURL)
        }
    }
}