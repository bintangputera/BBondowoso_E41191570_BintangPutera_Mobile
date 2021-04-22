package com.elapp.roomsqlitedemo.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tabel_mahasiswa")
@Parcelize
data class Mahasiswa(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    var nim: String?,
    var namaMahasiswa: String?,
    var tanggalLahir: String?,
    var jenisKelamin: String?,
    var alamat: String
) : Parcelable