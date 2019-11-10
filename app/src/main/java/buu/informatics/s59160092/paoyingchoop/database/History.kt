package buu.informatics.s59160092.paoyingchoop.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_score")
data class History(
    @PrimaryKey(autoGenerate = true)
    var historyId: Long? = 0L,

    @ColumnInfo(name = "name_Player1")
    var namePlayer1: String,

    @ColumnInfo(name = "name_Player2")
    var namePlayer2: String,

    @ColumnInfo(name = "score_Player1")
    var scorePlayer1: String,

    @ColumnInfo(name = "score_Player")
    var scorePlayer2: String
)