package com.sali.anikfood.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorites", foreignKeys = [
        // One-to-many relationship between User and Favorite
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("user_id"),
            childColumns = arrayOf("user_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        // Many-to-many to one relationship between Food and Favorite
        ForeignKey(
            entity = Food::class,
            parentColumns = arrayOf("food_id"),
            childColumns = arrayOf("food_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Favorite(

    @PrimaryKey(autoGenerate = true)
    val favoriteId: Int,

    @ColumnInfo(name = "user_id")
    val userId: Int,

    @ColumnInfo(name = "food_id")
    val foodId: Int

)
