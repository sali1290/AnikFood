package com.sali.anikfood.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "food_id")
    val foodId: Int,

    @ColumnInfo(name = "food_name")
    val foodName: String
)
