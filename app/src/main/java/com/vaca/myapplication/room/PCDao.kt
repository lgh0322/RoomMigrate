package com.vaca.myapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vaca.myapplication.room.PCdata

@Dao
interface PCDao {
    @Query("SELECT * FROM PCdata")
    fun getAll(): List<PCdata>

    @Query("SELECT * FROM PCdata  ORDER BY date DESC")
    fun getAllR(): List<PCdata>

    @Query("SELECT * FROM PCdata WHERE date IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<PCdata>

    @Insert
    fun insert(vararg item: PCdata)


    @Delete
    fun delete(PCdata: PCdata)


    @Query("DELETE FROM PCdata WHERE date = :myDate")
    fun deleteByDate(myDate: Long)



    @Query("SELECT * FROM PCdata WHERE date = :date")
    fun loadByDate(date: Long): PCdata




    @Query("SELECT * FROM PCdata WHERE date = :myDate")
    fun loadByIds(myDate: Long): PCdata

    @Query("DELETE FROM PCdata")
    fun delete()
}