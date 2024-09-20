package com.example.assignment7.firstScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment7.databinding.ColorViewBinding

class FirstScreenAdapter(
    private val colors : Array<String>
) : RecyclerView.Adapter<FirstScreenAdapter.FirstViewHolder>(){

    class FirstViewHolder(val binding : ColorViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ColorViewBinding.inflate(layoutInflater, parent, false)
        return FirstViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.binding.apply {
            tvColorName.text = colors[position]
        }
    }

}