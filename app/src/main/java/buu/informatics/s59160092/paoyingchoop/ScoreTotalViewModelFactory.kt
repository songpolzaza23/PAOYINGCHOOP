package buu.informatics.s59160092.paoyingchoop

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160092.paoyingchoop.database.HistoryDatabaseDAO

class ScoreTotalViewModelFactory (
    private val dataSource: HistoryDatabaseDAO,
    private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreTotalViewModel::class.java)) {
            return ScoreTotalViewModel(dataSource , application) as T
        }
        throw IllegalAccessException("Unknow")
    }

}