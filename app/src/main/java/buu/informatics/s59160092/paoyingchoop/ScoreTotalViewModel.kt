package buu.informatics.s59160092.paoyingchoop

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import buu.informatics.s59160092.paoyingchoop.database.HistoryDatabaseDAO

class ScoreTotalViewModel(
    val database: HistoryDatabaseDAO,
    application: Application) : AndroidViewModel(application) {


}