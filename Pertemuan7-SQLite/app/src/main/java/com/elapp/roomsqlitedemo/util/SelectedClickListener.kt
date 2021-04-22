package com.elapp.roomsqlitedemo.util

import com.elapp.roomsqlitedemo.db.entity.Mahasiswa

interface SelectedClickListener {
    fun onSelectedItem(mahasiswa: Mahasiswa)
    fun onDeleteItem(mahasiswa: Mahasiswa)
}