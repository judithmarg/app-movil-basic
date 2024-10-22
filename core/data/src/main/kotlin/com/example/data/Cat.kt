package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
class Cat (
    @ColumnInfo(name = "_id_image") var id_image: String,
    @ColumnInfo(name = "mimetype") var mimetype: String,
    @ColumnInfo(name = "tags") var tags: String,
    @ColumnInfo(name = "size") var size: Long,
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}