package com.example.todoapplication

import androidx.room.*

@Dao
interface DAO {
    @Insert
    fun insertTask(entity: Entity)

    @Update
    fun updateTask(entity: Entity)



    @Delete
    fun deleteTask(entity: Entity)

    @Query("DELETE FROM to_do")
    fun deleteAll()

    @Query("Select * from to_do")
    fun getTasks():List<CardInfo>
}