package com.example.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.ListItemBinding
import com.example.retrofitapp.model.User

class UserAdapter(private val user: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(user[position])
    }

    override fun getItemCount(): Int = user.size

    inner class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.txUser.text = user.fullName
        }
    }

}