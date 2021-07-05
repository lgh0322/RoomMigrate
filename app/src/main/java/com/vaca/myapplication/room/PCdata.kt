package com.vaca.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PCdata(
    @PrimaryKey val date: Long,
    @ColumnInfo(name = "dia") val dia: Int,
    @ColumnInfo(name = "note") val note: String=""
)