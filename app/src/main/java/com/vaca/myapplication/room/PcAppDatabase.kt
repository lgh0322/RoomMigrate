package com.vaca.myapplication.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PCdata::class],
    version = 2
)
abstract class PcAppDatabase : RoomDatabase() {
    abstract fun pcDao(): PCDao
}