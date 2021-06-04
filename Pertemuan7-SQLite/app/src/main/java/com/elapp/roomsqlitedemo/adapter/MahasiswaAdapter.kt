package com.elapp.roomsqlitedemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elapp.roomsqlitedemo.databinding.MahasiswaListItemBinding
import com.elapp.roomsqlitedemo.db.entity.Mahasiswa
import com.elapp.roomsqlitedemo.util.SelectedClickListener

class MahasiswaAdapter(
        private val selectedClickListener: SelectedClickListener)
    : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {
    private var mahasiswaList = ArrayList<Mahasiswa>()

    fun setList(mList: ArrayList<Mahasiswa>) {
        this.mahasiswaList = mList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MahasiswaAdapter.MahasiswaViewHolder {
        val view = MahasiswaListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int = mahasiswaList.size

    override fun onBindViewHolder(holder: MahasiswaAdapter.MahasiswaViewHolder, position: Int) {
        holder.bind(mahasiswaList.get(position))
        holder.itemView.setOnClickListener {
            selectedClickListener.onSelectedItem(mahasiswaList.get(position))
        }
        holder.binding.btnDelete.setOnClickListener {
            selectedClickListener.onDeleteItem(mahasiswaList.get(position))
        }
    }

    inner class MahasiswaViewHolder(val binding: MahasiswaListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(mahasiswa: Mahasiswa){
            binding.txNamaMahasiswa.text = mahasiswa.namaMahasiswa
            binding.txNimMahasiswa.text = mahasiswa.nim
        }
    }
}