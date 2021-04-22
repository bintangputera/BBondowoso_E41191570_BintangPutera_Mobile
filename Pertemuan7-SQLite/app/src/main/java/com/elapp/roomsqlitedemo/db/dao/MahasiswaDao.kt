package com.elapp.roomsqlitedemo.db.dao

import androidx.room.*
import com.elapp.roomsqlitedemo.db.entity.Mahasiswa

@Dao
interface MahasiswaDao {

    @Insert
    fun insertDataMahasiswa(mahasiswa: Mahasiswa)

    @Update
    fun updateDataMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM tabel_mahasiswa")
    fun getDataMahasiswa(): List<Mahasiswa>

    @Query("SELECT * FROM tabel_mahasiswa WHERE id = :id")
    fun getById(id: Int) : List<Mahasiswa>

    @Delete
    fun deleteMahasiswa(mahasiswa: Mahasiswa)

}