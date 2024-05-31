package com.example.inventory.data
import androidx.room.OnConflictStrategy
import androidx.room.Insert
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.Update
import androidx.room.Delete
@Dao
interface ItemDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(item: Item)

@Update
suspend fun update(item: Item)

@Delete
suspend fun delete(item: Item)

@Query("SELECT * from items WHERE id = :id")
fun getItem(id: Int): Flow<Item>
    abstract fun getAllItems(): Flow<List<Item>>
}