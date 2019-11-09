package buu.informatics.s59160092.paoyingchoop.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HistoryDatabaseDAO {

    @Insert
    fun insert(history: History)

    @Update
    fun update(history: History)

    @Query("SELECT * FROM history_score WHERE historyId = :key")
    fun get(key: Long) :History

    @Query("SELECT * FROM history_score ORDER BY historyId DESC LIMIT 1")
    fun getToHistory(): History?

    @Query("SELECT * FROM history_score ORDER BY historyId DESC")
    fun getAllHistory(): LiveData<List<History>>
}