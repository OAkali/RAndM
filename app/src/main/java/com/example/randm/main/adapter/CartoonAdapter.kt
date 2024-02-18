package com.example.randm.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.randm.R
import  com.example.randm.data.model.Character
import com.example.randm.databinding.ItemCartoonBinding
import com.example.randm.main.MainActivity


class CartoonAdapter(private val onClick: (Int)-> Unit):Adapter<CartoonAdapter.Holder>(){

    private var characters= listOf<Character>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
         return Holder(ItemCartoonBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int=characters.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(characters[position])

    }
    fun setList(list:List<Character>){
        characters=list
        notifyDataSetChanged()
    }
    inner class Holder(private val binding: ItemCartoonBinding):ViewHolder(binding.root){
        fun bind(character:Character)= with(binding){
            character.apply {
                tvName.text=name
                tvStatus.text=status
                Glide.with(ivChar).load(imege).into(ivChar)


                when (status){
                    R.string.alive.toString() ->circleIndicator.setBackgroundResource(R.drawable.green)
                    R.string.dead.toString() ->circleIndicator.setBackgroundResource(R.drawable.red)
                    R.string.unknown.toString() ->circleIndicator.setBackgroundResource(R.drawable.grey)

                }
                cartView.setOnClickListener {
                    onClick(id)
                }

            }
        }

    }

}