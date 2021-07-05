package com.vaca.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vaca.myapplication.room.PCdata
import com.vaca.myapplication.room.PcAppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val dataScope = CoroutineScope(Dispatchers.IO)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE PCdata ADD COLUMN note  TEXT NOT NULL DEFAULT ''")
            }
        }
        val pc100db = Room.databaseBuilder(
           application,
            PcAppDatabase::class.java, "pc100-name"
        ).addMigrations(MIGRATION_1_2)
            .build()
        dataScope.launch {
            pc100db.pcDao().insert(PCdata(System.currentTimeMillis(),322,"as"))
//            val gg=pc100db.pcDao().getAll();
//            Log.e("jkjk",gg[0].dia.toString()+"   "+gg.size)
        }
    }
}