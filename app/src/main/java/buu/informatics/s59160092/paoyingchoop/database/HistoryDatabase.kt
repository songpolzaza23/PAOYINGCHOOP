package buu.informatics.s59160092.paoyingchoop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [History::class], version = 1, exportSchema = false)
abstract class HistoryDatabase : RoomDatabase(){

    abstract val historyDatabaseDAO: HistoryDatabaseDAO

    companion object {

        @Volatile
        private var INSTANCE : HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, HistoryDatabase::class.java,"history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return INSTANCE as HistoryDatabase
            }
        }
    }
}