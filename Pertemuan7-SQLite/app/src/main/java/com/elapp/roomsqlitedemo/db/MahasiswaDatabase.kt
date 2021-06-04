package com.elapp.roomsqlitedemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elapp.roomsqlitedemo.db.dao.MahasiswaDao
import com.elapp.roomsqlitedemo.db.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], exportSchema = false, version = 2)
abstract class MahasiswaDatabase: RoomDatabase() {
    abstract fun getMahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile // makes the field visible to other thread
        private var INSTANCE: MahasiswaDatabase? = null

        fun getInstance(context: Context): MahasiswaDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == (null)) {
                    instance = Room.databaseBuilder(
                        context,
                        MahasiswaDatabase::class.java,
                        "mahasiswa_database"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}