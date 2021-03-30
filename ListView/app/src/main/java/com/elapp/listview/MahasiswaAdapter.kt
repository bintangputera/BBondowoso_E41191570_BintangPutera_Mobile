package com.elapp.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elapp.listview.databinding.ListItemBinding

class MahasiswaAdapter: RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    private lateinit var dataList: ArrayList<Mahasiswa>

    fun setList(mahasiwa: ArrayList<Mahasiswa>) {
        this.dataList = mahasiwa
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaAdapter.ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MahasiswaAdapter.ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(mahasiwa: Mahasiswa) {
            binding.txNamaMahasiswa.text = mahasiwa.nama
            binding.txNpmMahasiswa.text = mahasiwa.npm
            binding.txNohpMahasiswa.text = mahasiwa.noHp
        }
    }

}