package com.example.rickandmortycleancode.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortycleancode.model.CharacterEntity

class AppDataBase {
    @Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
    abstract class AppDataBase : RoomDatabase() {

        abstract fun characterDao(): CharacterDao
    }
}