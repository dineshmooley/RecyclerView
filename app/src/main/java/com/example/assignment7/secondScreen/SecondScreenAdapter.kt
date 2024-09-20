package com.example.assignment7.secondScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment7.R
import com.example.assignment7.databinding.ColorItemBinding

class SecondScreenAdapter(
    private val colors: Array<String>
) : RecyclerView.Adapter<SecondScreenAdapter.SecondViewHolder>()    {

    class SecondViewHolder(val binding: ColorItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ColorItemBinding.inflate(layoutInflater, parent, false)
        return SecondViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.binding.apply {
            tvColor.text = colors[position]
            tvNumber.text = (position + 1).toString()
        }
    }

}